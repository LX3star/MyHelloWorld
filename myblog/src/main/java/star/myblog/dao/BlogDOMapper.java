package star.myblog.dao;

import star.myblog.pojo.domain.BlogDO;

public interface BlogDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogDO record);

    int insertSelective(BlogDO record);

    BlogDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogDO record);

    int updateByPrimaryKeyWithBLOBs(BlogDO record);

    int updateByPrimaryKey(BlogDO record);
}