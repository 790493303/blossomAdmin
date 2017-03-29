package com.blossom.site.log.mapper;

import com.blossom.site.common.persistence.sql.annotation.MyBatisDao;
import com.blossom.site.common.persistence.sql.mapper.CrudMapper;
import com.blossom.site.log.entity.SystemLogDo;

/**
 * @author Blossom
 * @Description 系统日志Mapper
 * @time 2017/3/23 18:05
 */
@MyBatisDao
public interface SystemLogMapper extends CrudMapper<SystemLogDo> {

}
