package com.blossom.site.log.mapper;

import com.blossom.site.common.persistence.sql.annotation.MyBatisDao;
import com.blossom.site.common.persistence.sql.mapper.CrudMapper;
import com.blossom.site.log.entity.HandleLogDo;

/**
 * @author Blossom
 * @Description 操作日志Mapper
 * @time 2017/3/23 18:11
 */
@MyBatisDao
public interface HandleLogMapper extends CrudMapper<HandleLogDo> {

}
