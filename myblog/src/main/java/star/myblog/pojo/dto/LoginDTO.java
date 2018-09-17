package star.myblog.pojo.dto;

/**
 * 
 * TODO 登录页面验证传输数据封装对象
 * 
 * @author huangzq
 * @mailbox 1375529585@qq.com
 * @date 2018年9月10日 下午4:22:37
 * @project myblog
 *
 */
public class LoginDTO {
	private String name;
	private String password;
	// 验证码
	private String validCode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getValidCode() {
		return validCode;
	}

	public void setValidCode(String validCode) {
		this.validCode = validCode;
	}

}
