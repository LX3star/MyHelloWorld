package star.myblog.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import star.myblog.common.BaseController;
import star.myblog.common.FMView;
import star.myblog.common.ResultBuilderModel;
import star.myblog.common.ResultModel;
import star.myblog.common.SystemParameterConstant;
import star.myblog.pojo.domain.DistrictDO;
import star.myblog.pojo.dto.LoginDTO;
import star.myblog.service.DistrictService;
import star.myblog.service.LoginService;
import star.myblog.util.GaoDeRequestUtil;
import star.myblog.util.MyJSONObejctToList;

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
	@Autowired
	private DistrictService districtService;
	
	/**
	 * 得到登录页面
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public FMView getPage(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

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
	
	/**
	 * @throws UnsupportedEncodingException 
	 * 
	 */
	@RequestMapping(value = "/getData", method = RequestMethod.GET)
	@ResponseBody
	public void wirteDistrictData() throws UnsupportedEncodingException {
		Integer reuslt = districtService.getStreetData();
		
		System.out.println(reuslt);
	}
}
