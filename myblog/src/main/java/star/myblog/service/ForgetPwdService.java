package star.myblog.service;

import star.myblog.common.MyblogException;
import star.myblog.common.ResultModel;

/**
 * 
 * TODO 找回密码的服务层接口
 * @author huangzq
 * @mailbox 1375529585@qq.com
 * @date 2018年9月12日 上午11:59:32
 * @project myblog
 *
 */
public interface ForgetPwdService {
	
	/**
	 * 验证密保问题
	 * @param name 账户名
	 * @param type	密保问题类型
	 * @param answer 密保问题答案
	 * @return
	 * @throws MyblogException
	 */
	ResultModel verifyPaswordSafe(String name, Integer type, String answer) throws MyblogException;

}
