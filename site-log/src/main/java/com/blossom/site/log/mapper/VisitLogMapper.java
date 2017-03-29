package com.blossom.site.log.mapper;

import com.blossom.site.common.persistence.sql.annotation.MyBatisDao;
import com.blossom.site.common.persistence.sql.mapper.CrudMapper;
import com.blossom.site.log.entity.VisitLogDo;

/**
 * @author Blossom
 * @Description 访问日志Mapper
 * @time 2017/3/24 9:49
 */
@MyBatisDao
public interface VisitLogMapper extends CrudMapper<VisitLogDo> {
}
