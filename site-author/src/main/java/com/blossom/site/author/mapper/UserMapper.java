package com.blossom.site.author.mapper;

import com.blossom.site.author.entity.UserDo;
import com.blossom.site.common.persistence.sql.annotation.MyBatisDao;
import com.blossom.site.common.persistence.sql.mapper.CrudMapper;

/**
 * @author Blossom
 * @Description 用户mapper
 * @time 2017/3/25 21:38
 */
@MyBatisDao
public interface UserMapper extends CrudMapper<UserDo>{
}
