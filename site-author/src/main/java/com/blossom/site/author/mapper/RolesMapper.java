package com.blossom.site.author.mapper;

import com.blossom.site.author.entity.RoleDo;
import com.blossom.site.common.persistence.sql.annotation.MyBatisDao;
import com.blossom.site.common.persistence.sql.mapper.CrudMapper;

/**
 * @author Blossom
 * @Description 角色Mapper
 * @time 2017/3/25 21:41
 */
@MyBatisDao
public interface RolesMapper extends CrudMapper<RoleDo> {
}
