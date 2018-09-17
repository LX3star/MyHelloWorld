package star.myblog.service;


import com.alibaba.fastjson.JSONArray;

import star.myblog.common.MyblogException;
import star.myblog.common.ResultModel;
import star.myblog.pojo.domain.UserDO;


/**
 * 
 * TODO 注册服务的接口层
 * @author huangzq
 * @mailbox 1375529585@qq.com
 * @date 2018年9月12日 上午10:06:45
 * @project myblog
 *
 */
public interface RegisterService {
	
	JSONArray getPwdSafeCombobox();

	ResultModel addNewUser(UserDO userDo, String answer, Integer type) throws MyblogException;
	
}
