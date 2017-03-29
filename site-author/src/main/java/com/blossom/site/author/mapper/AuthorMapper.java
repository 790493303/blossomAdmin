package com.blossom.site.author.mapper;

import com.blossom.site.author.entity.AuthorDo;
import com.blossom.site.common.persistence.sql.annotation.MyBatisDao;
import com.blossom.site.common.persistence.sql.mapper.CrudMapper;

/**
 * @author Blossom
 * @Description 权限Mapper
 * @time 2017/3/25 21:42
 */
@MyBatisDao
public interface AuthorMapper extends CrudMapper<AuthorDo>{
}
