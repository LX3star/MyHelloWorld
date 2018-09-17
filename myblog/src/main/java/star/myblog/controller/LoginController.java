package star.myblog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import star.myblog.common.BaseController;
import star.myblog.common.FMView;
import star.myblog.common.ResultBuilderModel;
import star.myblog.common.ResultModel;
import star.myblog.common.SystemParameterConstant;
import star.myblog.pojo.dto.LoginDTO;
import star.myblog.service.LoginService;

/**
 * 登录页面的控制层
 * TODO
 * @author huangzq
 * @mailbox 1375529585@qq.com
 * @date 上午10:44:36
 * @project myblog
 *
 */
@Controller
@RequestMapping(value = "login")
public class LoginController extends BaseController {
	
	// 日志对象
	private static final String TIP = "[登录]";
	
	// 注入服务
	@Autowired
	private LoginService loginService;
	
	/**
	 * 得到登录页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public FMView getPage(HttpServletRequest request, HttpServletResponse response) {
		FMView page = new FMView("/newLogin");	
		return page;
	}	
	
	/**
	 * 登录验证方法
	 * @param loginDto 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/tryLogin", method = RequestMethod.POST)
	@ResponseBody
	public ResultModel login(LoginDTO loginDto, HttpServletRequest request) {
		try {
			return loginService.tryLogin(loginDto, request);
		} catch (Exception e) {
			this.logger.error(TIP + e.getMessage());
			return ResultBuilderModel.Failure(SystemParameterConstant.SYSTEM_ERROR);
		}
	}
	
	
}
