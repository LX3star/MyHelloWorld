package star.myblog.dao;

import java.util.List;

import star.myblog.pojo.domain.DistrictDO;

public interface DistrictDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DistrictDO record);

    int insertSelective(DistrictDO record);

    DistrictDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DistrictDO record);

    int updateByPrimaryKey(DistrictDO record);

	List<String> selectCityCode();
}