package star.myblog.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 
 * TODO
 * @author huangzq
 * @time 2018年9月26日
 * @project_name myblog
 * @mailbox 1375529585@qq.com
 */
public class GaoDeRequestUtil {
	private static final String KEY = "e872757e58a7bad379d510c1f828628c";
	private static final String RETURN_TYPE = "JSON";
	private static final String GAODE_API_URL = "https://restapi.amap.com/v3/config/district";
	
	/**
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String getData() throws UnsupportedEncodingException {

		Map<String, String> param = new HashMap<>();
		param.put("keywords", "100000");
		param.put("subdistrict", "3");
		param.put("extensions", "base");
		String url = joinMyStrUrl(param, RETURN_TYPE, KEY, GAODE_API_URL);
		return HttpRequestUrlUtil.doPost(url, param);
	}
	
	/**
	 * 
	 * @param cityCode
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String getCityData(String cityCode) throws UnsupportedEncodingException {

		Map<String, String> param = new HashMap<>();
		param.put("keywords", cityCode);
		param.put("subdistrict", "3");
		param.put("extensions", "base");
		String url = joinMyStrUrl(param, RETURN_TYPE, KEY, GAODE_API_URL);
		return HttpRequestUrlUtil.doPost(url, param);
	}
	
	/**
	 * 
	 * @param param
	 * @param output
	 * @param key
	 * @param url
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private static String joinMyStrUrl(Map<String, String> param, String output, String key, String url) throws UnsupportedEncodingException {
		StringBuilder baseUrl = new StringBuilder();
		baseUrl.append(url);
		int index = 0;
		Set<Map.Entry<String, String>> entrys = param.entrySet();
		for (Map.Entry<String, String> node : entrys) {
			// 判断是否是第一个参数
			if (index == 0) {
				baseUrl.append("?");
			} else {
				baseUrl.append("&");
			} 
			baseUrl.append(node.getKey()).append("=").append(URLEncoder.encode(node.getValue(), "utf-8"));
			index++;
			
		}
		baseUrl.append("&output=").append(output).append("&key=").append(key);
		return baseUrl.toString();
	}
	
	
}
