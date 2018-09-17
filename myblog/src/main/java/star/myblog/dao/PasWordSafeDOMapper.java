package star.myblog.dao;

import star.myblog.pojo.domain.PasWordSafeDO;
import star.myblog.pojo.dto.PasWordSafeDTO;

public interface PasWordSafeDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PasWordSafeDO record);

    int insertSelective(PasWordSafeDO record);

    PasWordSafeDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PasWordSafeDO record);

    int updateByPrimaryKey(PasWordSafeDO record);

	PasWordSafeDO selectByPasWordSafeDTO(PasWordSafeDTO pasWordSafeDto);
}