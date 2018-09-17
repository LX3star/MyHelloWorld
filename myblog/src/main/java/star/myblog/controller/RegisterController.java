package star.myblog.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

import star.myblog.common.BaseController;
import star.myblog.common.FMView;
import star.myblog.common.ResultBuilderModel;
import star.myblog.common.ResultModel;
import star.myblog.common.SystemParameterConstant;
import star.myblog.pojo.domain.UserDO;
import star.myblog.service.RegisterService;

/**
 * 
 * TODO 注册页面的控制层
 * @author huangzq
 * @mailbox 1375529585@qq.com
 * @date 2018年9月12日 上午10:02:04
 * @project myblog
 *
 */
@RequestMapping(value = "/register")
@Controller
public class RegisterController extends BaseController {
	
	private static final String TIP = "注册";
	
	// 注入服务
	@Autowired
	private RegisterService registerService;
	
	/**
	 * 得到注册页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/main")
	public FMView getPage(HttpServletRequest request, HttpServletResponse response) {
		FMView page = new FMView("/register");
		return page;
	}
	
	/**
	 * 得到组装密保问题的combobox数据
	 * @return
	 */
	@RequestMapping(value = "/getPwdSafeJSON", method = RequestMethod.POST)
	@ResponseBody
	public JSONArray getPwdSafeListJson() {
		JSONArray result = new JSONArray();
		try {
			result = registerService.getPwdSafeCombobox();
		}catch (Exception e) {
			this.logger.error(TIP + e.getMessage());
		}
		return result;
	}
	
	/**
	 * 实现注册新用户的控制层
	 * @param userDo 用户信息的封装类
	 * @return
	 */
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	@ResponseBody
	public ResultModel RegisterNewUser(UserDO userDo, String answer, Integer type) {
		try {
			return registerService.addNewUser(userDo, answer, type);
		} catch (Exception e) {
			this.logger.error(TIP + e.getMessage());
			return ResultBuilderModel.Failure(SystemParameterConstant.SYSTEM_ERROR);
		}

	}
}
