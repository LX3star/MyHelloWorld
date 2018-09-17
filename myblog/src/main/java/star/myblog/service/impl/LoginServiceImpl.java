package star.myblog.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import star.myblog.common.MyblogException;
import star.myblog.common.ResultBuilderModel;
import star.myblog.common.ResultModel;
import star.myblog.common.SystemParameterConstant;
import star.myblog.dao.UserDOMapper;
import star.myblog.pojo.dto.LoginDTO;
import star.myblog.pojo.dto.LoginPersonDTO;
import star.myblog.service.LoginService;
import star.myblog.util.MD5Util;

/**
 * 
 * TODO 登录页面服务实现层
 * @author huangzq
 * @mailbox 1375529585@qq.com
 * @date 上午10:47:52
 * @project myblog
 *
 */
@Service
public class LoginServiceImpl implements LoginService {
	// 数据库持久化层
	@Autowired 
	private UserDOMapper userDoMapper;
	
	/**
	 * 登录验证方法
	 * @throws MyblogException 
	 */
	@Override
	public ResultModel tryLogin(LoginDTO loginDto, HttpServletRequest request) throws MyblogException {
		// 获取浏览器缓存中的验证码，进行验证码是否相同
		String validCode = (String) request.getSession()
			.getAttribute(SystemParameterConstant.SESSION_VALIDCODE_KEY);
		// 验证码不区分大小写
		if (validCode == null || !validCode.equalsIgnoreCase(loginDto.getValidCode())) {
			throw new MyblogException(SystemParameterConstant.VALIDCODE_ERROR);
		}
		// 前端传回的验证账号密码
		String pwd = loginDto.getPassword();
		// 进行md5加密
		String pwsMD5 = MD5Util.encodeByMD5(pwd);
		loginDto.setPassword(pwsMD5);
		LoginPersonDTO loginPersonDTO = userDoMapper.selectByLoginDTO(loginDto);
		if (loginPersonDTO == null) {
			throw new MyblogException(SystemParameterConstant.NAME_OR_PWD_ERROR);
		}
		
		// 增加了一些session值 
		// 保存用户数据到session
		HttpSession seesion = request.getSession();
		// 登录者信息封装对象
		seesion.setAttribute(SystemParameterConstant.SESSION_USER_KEY, loginPersonDTO);
		// 移除session中的验证码 释放内存
		seesion.removeAttribute(SystemParameterConstant.SESSION_VALIDCODE_KEY);
		
		return ResultBuilderModel.Success("success");
	}
	
}
