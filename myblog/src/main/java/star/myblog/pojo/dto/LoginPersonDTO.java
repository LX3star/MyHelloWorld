package star.myblog.pojo.dto;
/**
 * 
 * TODO 登录者的信息封装类
 * @author huangzq
 * @mailbox 1375529585@qq.com
 * @date 2018年9月10日 下午5:15:19
 * @project myblog
 *
 */
public class LoginPersonDTO {
	private Integer id;
	private String name;
	private String password;
	// 密保类型
	private Integer pasWordSafeType;
	// 密保答案
	private String pasWordSafeAnswer;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public Integer getPasWordSafeType() {
		return pasWordSafeType;
	}
	public void setPasWordSafeType(Integer pasWordSafeType) {
		this.pasWordSafeType = pasWordSafeType;
	}
	public String getPasWordSafeAnswer() {
		return pasWordSafeAnswer;
	}
	public void setPasWordSafeAnswer(String pasWordSafeAnswer) {
		this.pasWordSafeAnswer = pasWordSafeAnswer;
	}
	
	
}
