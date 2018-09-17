package star.myblog.dao;

import star.myblog.pojo.domain.UserDO;
import star.myblog.pojo.dto.LoginDTO;
import star.myblog.pojo.dto.LoginPersonDTO;

public interface UserDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserDO record);

    int insertSelective(UserDO record);

    UserDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKey(UserDO record);

    UserDO selectByName(String name);

	LoginPersonDTO selectByLoginDTO(LoginDTO loginDto);
}