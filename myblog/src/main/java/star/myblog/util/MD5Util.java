package star.myblog.util;

import java.security.MessageDigest;
import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * 
 * TODO md5加密工具
 * @author huangzq
 * @mailbox 1375529585@qq.com
 * @date 2018年9月10日 下午4:51:51
 * @project myblog
 *
 */
public class MD5Util {
	// 加密替换的字符
	private static final String HEX_DIGITS[] = {"0", "1", "2", "3", "4", "5",
	        "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
	/**
	 * 对传入字符串参数进行md5加密，不指定编码格式，默认utf-8
	 * @param parameterStr 需要md5加密的字符串参数
	 * @return 加密后的字符串
	 */
	public static String encodeByMD5(String parameterStr) {
		return encodeByMD5(parameterStr, null);
		
	}
	
	/**
	 * 对传入字符串参数进行md5加密，指定编码格式
	 * @param parameterStr 需要md5加密的字符串参数
	 * @param charsetName 编码格式例如utf-8
	 * @return 加密后的字符串
	 */
	public static String encodeByMD5(String parameterStr, String charsetName) {
		String resultString = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			// 默认使用utf-8编码
			if (charsetName == null || charsetName.equals("")) {
				resultString = byteArrayToHexString(md
					.digest(parameterStr.getBytes(UTF_8)));
			}else {
				resultString = byteArrayToHexString(md
						.digest(parameterStr.getBytes(charsetName)));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return resultString;
		
	}

	private static String byteArrayToHexString(byte[] digest) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < digest.length; i++) {
			resultSb.append(byteToHexString(digest[i]));
		}

		return resultSb.toString();
	}

	private static Object byteToHexString(byte b) {
		int n = b;
        if (n < 0) {
        	n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return HEX_DIGITS[d1] + HEX_DIGITS[d2];
	}
}
