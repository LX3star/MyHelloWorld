package star.myblog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import star.myblog.common.MyblogException;
import star.myblog.common.ResultBuilderModel;
import star.myblog.common.ResultModel;
import star.myblog.common.SystemParameterConstant;
import star.myblog.dao.PasWordSafeDOMapper;
import star.myblog.dao.UserDOMapper;
import star.myblog.pojo.domain.PasWordSafeDO;
import star.myblog.pojo.domain.UserDO;
import star.myblog.service.RegisterService;
import star.myblog.util.MD5Util;
import star.myblog.util.PaswordSafeEnum;

/**
 * 
 * TODO 注册页面的服务层
 * @author huangzq
 * @mailbox 1375529585@qq.com
 * @date 2018年9月12日 上午10:06:15
 * @project myblog
 *
 */
@Service
public class RegisterServiceImpl implements RegisterService {
	// 数据库持久化层
	@Autowired 
	private UserDOMapper userDoMapper;
	@Autowired
	private PasWordSafeDOMapper pasWordSafeDOMapper;
	/**
	 * 得到组装密保问题的combobox数据
	 */
	@Override
	public JSONArray getPwdSafeCombobox() {
		JSONArray result = new JSONArray();
		// 递归密保问题枚举类
		for (PaswordSafeEnum PwdEnum : PaswordSafeEnum.values()) {
			JSONObject node = new JSONObject();
			node.put("id", PwdEnum.getType());
			node.put("text", PwdEnum.getQuestionStr());
			result.add(node);
		}
		return result;
	}
	
	/**
	 * 注册新用户
	 * @throws MyblogException 
	 */
	@Override
	public ResultModel addNewUser(UserDO userDo, String answer, Integer type) throws MyblogException {
		// 注册信息中的名字
		String name = userDo.getName();
		// 名称已经存在
		if (userDoMapper.selectByName(name) != null) {
			throw new MyblogException(SystemParameterConstant.USER_NAME_EXIT);
		}
		// 对密码进行md5加密
		String pwd = userDo.getPassword();
		pwd = MD5Util.encodeByMD5(pwd);
		userDo.setPassword(pwd);
		// 新注册用户
		userDoMapper.insertSelective(userDo);
		// 新添加密保问题
		PasWordSafeDO pasWordSafeDo = new PasWordSafeDO();
		pasWordSafeDo.setAnswer(answer);
		pasWordSafeDo.setType(type);
		// 新用户的id
		UserDO newUserDo = userDoMapper.selectByName(name);
		pasWordSafeDo.setUser_id(newUserDo.getId());
		pasWordSafeDOMapper.insertSelective(pasWordSafeDo);
		return ResultBuilderModel.Success(SystemParameterConstant.REGISTER_SUCCESS);
	}
	

}
