package star.myblog.common;

import org.springframework.web.context.ContextLoader;

/**
 * 
 * TODO 系统常量类
 * 
 * @author huangzq
 * @mailbox 1375529585@qq.com
 * @date 上午10:41:35
 * @project myblog
 *
 */
public class SystemParameterConstant {
	/** web容器的访问路径 */
	public static final String WEBAPP_PATH = (String) ContextLoader.getCurrentWebApplicationContext()
		.getBean("appPath");

	/** 验证码 在session里面的key */
	public static final String SESSION_VALIDCODE_KEY = "piccode";

	/** user 在session里面的key */
	public static final String SESSION_USER_KEY = "loginPerson";

	
	/************ 提示信息start *********************/
	public static final String SYSTEM_ERROR = "系统繁忙，请稍后再试！";

	public static final String REGISTER_SUCCESS = "注册成功";

	public static final String USER_NAME_EXIT = "账户名称已经存在";

	public static final String VALIDCODE_ERROR = "验证码错误";

	public static final String NAME_OR_PWD_ERROR = "账户名称或者密码错误";
	
	public static final String PASWORDSAFE_ADD_SUCCESS = "密保问题添加成功";
	
	public static final String PASWORDSAFE_ERROR = "密保问题错误";
	/************ 提示信息end *********************/

	
	
	/************ 密保问题 **************/
	public static final String PASWOEDSAFE_QUESTION_1 = "你最喜欢的颜色？";
	public static final String PASWOEDSAFE_QUESTION_2 = "你最喜欢的水果？";
	public static final String PASWOEDSAFE_QUESTION_3 = "你的星星是？";
	public static final String PASWOEDSAFE_QUESTION_4 = "你的星星是？";
	public static final String PASWOEDSAFE_QUESTION_5 = "你的生日是？";
}
