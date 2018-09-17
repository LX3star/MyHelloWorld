package star.myblog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import star.myblog.common.MyblogException;
import star.myblog.common.ResultBuilderModel;
import star.myblog.common.ResultModel;
import star.myblog.common.SystemParameterConstant;
import star.myblog.dao.PasWordSafeDOMapper;
import star.myblog.pojo.domain.PasWordSafeDO;
import star.myblog.pojo.dto.PasWordSafeDTO;
import star.myblog.service.ForgetPwdService;

/**
 * 
 * TODO 找回密码的服务层
 * @author huangzq
 * @mailbox 1375529585@qq.com
 * @date 2018年9月12日 上午11:59:13
 * @project myblog
 *
 */
@Service
public class ForgetPwdServiceImpl implements ForgetPwdService {
	
	@Autowired
	private PasWordSafeDOMapper paswordSafeDOMapper;
	
	/**
	 * 验证密保
	 * @throws MyblogException 
	 */
	@Override
	public ResultModel verifyPaswordSafe(String name, Integer type, String answer) throws MyblogException {
		PasWordSafeDTO pasWordSafeDto = new PasWordSafeDTO();
		pasWordSafeDto.setAnswer(answer);
		pasWordSafeDto.setName(name);
		pasWordSafeDto.setType(type);
		
		PasWordSafeDO pasWordSafeDO = paswordSafeDOMapper.selectByPasWordSafeDTO(pasWordSafeDto);
		
		if (pasWordSafeDO == null) {
			throw new MyblogException(SystemParameterConstant.PASWORDSAFE_ERROR);
		}
		return ResultBuilderModel.Success("success");
	}

}
