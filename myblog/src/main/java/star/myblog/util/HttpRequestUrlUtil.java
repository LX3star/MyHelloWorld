package star.myblog.util;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;
import java.nio.charset.CodingErrorAction;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import com.google.common.collect.Lists;

/**
 * 
 * TODO 一个互联网url请求通用类
 * 
 * @author huangzq
 * @time 2018年9月23日
 * @project_name myblog
 * @mailbox 1375529585@qq.com
 */
public class HttpRequestUrlUtil {

	// 连接池最大连接数
	private static final int MAX_TOTAL_CONNECTIONS = 4000;

	// 设置每个路由器的默认连接个数
	private static final int DEFAULT_MAX_PER_ROUTE = 200;
	// 请求的请求超时时间 单位毫秒
	private static final int REQUEST_CONNECTION_TIMEOUT = 8 * 1000;
	// 请求的连接超时时间，单位毫秒
	private static final int REQUESR_CONNECTION_REQUEST_TIMEOUT = 5 * 1000;
	// 连接闲置多久后需要重新检测单位毫秒
	private static final int VALIDATE_AFTER_IN_ACTIVITY = 2 * 1000;
	// 关闭socket,要么发送完数据，要么等待多少时间后就关闭连接，此时socket.close（）是阻塞的单位秒
	private static final int SOCKET_CONFIG_SO_LINGER = 60;
	// 接收数据的等待超时时间单位ms
	private static final int SOCKET_CONFIG_SO_TIMEOUT = 5 * 100;
	// 重试次数
	private static final int RETRY_COUNT = 5;
	// 声明为static volatile 会迫使线程每次读取时作为一个全局变量读取
	private static volatile CloseableHttpClient client = null;
	
	/**
	 * get类型的请求方式
	 * @param url 网址url
	 * @return
	 */
	public static String doGet(String url) {
		String respondBody;
		HttpGet httpGet = new HttpGet(url);
		try {
			httpGet.setConfig(getMyRequestConfig());
			respondBody = executeMyRequest(httpGet);			
		} catch (Exception e) {
			throw new RuntimeException("doGet方法发生异常", e);
		} finally {
			//  释放资源
			httpGet.releaseConnection();
		}
		return respondBody;
	}
	
	/**
	 * get类型的请求方式 运行使用参数组装url
	 * @param url
	 * @param param
	 * @return
	 */
	public static String doGet(String url, Map<String, Object> param) {
		String urlParm = getMyGetUrlFormParam(url, param);
		return doGet(urlParm);
	}
	
	/**
	 * 	  带 map参数get请求, 此方法会将map参数拼接到连接地址上
	 * 
	 * @param url
	 * @param param
	 * @return
	 */
	private static String getMyGetUrlFormParam(String url, Map<String, Object> param) {
		
		return null;
	}
	
	/**
	 * 
	 * @param url
	 * @param param
	 * @param contentType
	 * @return
	 */
	public static String doPost(String url, String param, ContentType contentType) {
		String responseBody;
		HttpPost httpPost = new HttpPost(url);
		try {
			StringEntity reqEntity = new StringEntity(param, contentType);
			httpPost.setEntity(reqEntity);
			httpPost.setConfig(getMyRequestConfig());
			responseBody = executeMyRequest(httpPost);
		} catch (IOException e){
			throw new RuntimeException("httpclient doPost方法异常", e);
		} finally {
			httpPost.releaseConnection();
		}
		return responseBody;

	}
	
	/**
	 * 
	 * @param url
	 * @param param
	 * @return
	 */
	public static String doPost(String url, Map<String, String> param) {
		String responseBody;
		HttpPost httpPost = new HttpPost(url);
		try {
			List<BasicNameValuePair> nvps = Lists.newArrayList();
			for (Map.Entry<String, String> entry : param.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();
				nvps.add(new BasicNameValuePair(key, value));
			}
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
			httpPost.setConfig(getMyRequestConfig());
			responseBody = executeMyRequest(httpPost);
		} catch (Exception e) {
			throw new RuntimeException("httpclient doPost方法异常", e);
		} finally {
			httpPost.releaseConnection();
		}
		
		return responseBody;
	}
	
	/**
	 * 通用执行请求方法
	 * @param httpGet
	 * @return
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	private static String executeMyRequest(HttpUriRequest method) throws ClientProtocolException, IOException {
		ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
			
			@Override
			public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
				int status = response.getStatusLine().getStatusCode();
				String result;
				if (status >= HttpStatus.SC_OK && status < HttpStatus.SC_MULTIPLE_CHOICES) {
					HttpEntity entity = response.getEntity();
					result = entity != null ? EntityUtils.toString(entity) : null;
					EntityUtils.consume(entity);
					return result;
				} else {
					throw new ClientProtocolException("unexpected response status" + status);
				}
			}
		};
		String result = getMyHttpClientInstance().execute(method, responseHandler);
		return result;
	}
	
	/**
	 * 单例获取httpclient实例
	 * @return
	 */
	private static CloseableHttpClient getMyHttpClientInstance() {
		if (client == null) {
			synchronized (CloseableHttpClient.class) {
				if (client == null) {
					client = HttpClients.custom().setConnectionManager(initMyConfig()).setRetryHandler(getMyRetryHandeler()).build();
				}
			}
		}
		return client;
	}
	
	/**
	 *  获取重试handler
	 * @return
	 */
	private static HttpRequestRetryHandler getMyRetryHandeler() {
		
		return new HttpRequestRetryHandler() {
			
			@Override
			public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
				// 假设重试五次了，就放弃
				if (executionCount > RETRY_COUNT) {
					return false;
				}
				if (exception instanceof NoHttpResponseException) {
					// 假设server丢掉了连接那么就重试
					return true;
				}
				// 不要重试ssl握手异常
				if (exception instanceof SSLHandshakeException) {
					return false;
				}
				// 连接超时
				if (exception instanceof InterruptedIOException) {
					return false;
				}
				// 目标server不可达
				if (exception instanceof UnknownHostException) {
					return false;
				}
				// 连接被拒绝
				if (exception instanceof ConnectTimeoutException) {
					return false;
				}
				// ssl握手异常
				if (exception instanceof SSLException) {
					return false;
				}
				HttpRequest request = HttpClientContext.adapt(context).getRequest();
				// 假设请求的幂等的，就再次尝试
				return !(request instanceof HttpEntityEnclosingRequest);
			}
		};
	}

	/**
	 * 初始化连接池的配置信息
	 * @return
	 */
	@SuppressWarnings("deprecation")
	private static PoolingHttpClientConnectionManager initMyConfig() {
		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create().register("http", PlainConnectionSocketFactory.INSTANCE)
			.register("https", new SSLConnectionSocketFactory(SSLContexts.createSystemDefault())).build();
		
		/**
		 * 以下参数设置含义分别为:   
         * 1 是否立即发送数据，设置为true会关闭Socket缓冲，默认为false
         * 2 是否可以在一个进程关闭Socket后，即使它还没有释放端口，其它进程还可以立即重用端口
         * 3 接收数据的等待超时时间，单位ms
         * 4 关闭Socket时，要么发送完所有数据，要么等待多少秒后，就关闭连接，此时socket.close()是阻塞的
         * 5 开启监视TCP连接是否有效
         * *其中setTcpNoDelay(true)设置是否启用Nagle算法，设置true后禁用Nagle算法，默认为false（即默认启用Nagle算法）。
         * Nagle算法试图通过减少分片的数量来节省带宽。当应用程序希望降低网络延迟并提高性能时，
         * 1它们可以关闭Nagle算法，这样数据将会更早地发 送，但是增加了网络消耗。 单位为：毫秒
         */
		PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
		SocketConfig socketConfig = SocketConfig.custom().setTcpNoDelay(true).setSoReuseAddress(true).setSoTimeout(SOCKET_CONFIG_SO_TIMEOUT).build();
		connManager.setDefaultSocketConfig(socketConfig);
		connManager.setValidateAfterInactivity(VALIDATE_AFTER_IN_ACTIVITY);
		
		ConnectionConfig connectionConfig = ConnectionConfig.custom().setMalformedInputAction(CodingErrorAction.IGNORE).setUnmappableInputAction(CodingErrorAction.IGNORE)
			.setCharset(Consts.UTF_8).build();
		
		connManager.setDefaultConnectionConfig(connectionConfig);
		connManager.setDefaultMaxPerRoute(DEFAULT_MAX_PER_ROUTE);
		connManager.setMaxTotal(MAX_TOTAL_CONNECTIONS);
		return connManager;
	}

	/**
	 *  获得请求配置信息
	 * @return
	 */
	private static RequestConfig getMyRequestConfig() {
		RequestConfig defaultRequestConfig = RequestConfig.custom().setExpectContinueEnabled(true).build();
		RequestConfig result = RequestConfig.copy(defaultRequestConfig).setSocketTimeout(REQUEST_CONNECTION_TIMEOUT).setConnectionRequestTimeout(REQUESR_CONNECTION_REQUEST_TIMEOUT).build();
		
		return result;
	}


}
