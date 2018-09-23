package star.myblog.service;

import javax.servlet.http.HttpServletRequest;

import star.myblog.common.MyblogException;
import star.myblog.common.ResultModel;
import star.myblog.pojo.dto.LoginDTO;

/**
 * 
 * TODO 登录页面服务接口层
 * @author huangzq
 * @mailbox 1375529585@qq.com
 * @date 上午10:48:16
 * @project myblog
 *
 */
public interface LoginService {
	
	/**
	 * 验证登录
	 * @param loginDto 
	 * @param request
	 * @return
	 * @throws MyblogException 
	 */
	ResultModel tryLogin(LoginDTO loginDto, HttpServletRequest request) throws MyblogException;
	
	

}
