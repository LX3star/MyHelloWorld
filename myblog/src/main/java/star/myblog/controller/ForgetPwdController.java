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
import star.myblog.service.ForgetPwdService;

/**
 * 
 * TODO 忘记密码或找回密码的控制层
 * @author huangzq
 * @mailbox 1375529585@qq.com
 * @date 2018年9月12日 上午11:56:01
 * @project myblog
 *
 */
@RequestMapping(value = "")
@Controller
public class ForgetPwdController extends BaseController {
	private static final String TIP = "找回密码";
	
	// 注入服务
	@Autowired
	private ForgetPwdService forgetPwdService;
	
	/**
	 * 得到页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public FMView getPage(HttpServletRequest request, HttpServletResponse response) {
		FMView page = new FMView("");
		return page;
	}
	
	/**
	 * 点击忘记密码的操作，验证账户名和密保问题答案
	 * @param name 账户名
	 * @param type	密保问题
	 * @param answer	密保问题答案
	 * @return
	 */
	@RequestMapping(value = "/lkk", method = RequestMethod.POST)
	@ResponseBody
	public ResultModel forgetPassword(String name, Integer type, String answer) {
		try {
			return forgetPwdService.verifyPaswordSafe(name, type, answer);
		} catch(Exception e) {
			this.logger.error(TIP + e.getMessage());
			return ResultBuilderModel.Failure(SystemParameterConstant.SYSTEM_ERROR);
		}
	}
}
