package com.blossom.site.manager.mapper;

import com.blossom.site.common.persistence.sql.annotation.MyBatisDao;
import com.blossom.site.common.persistence.sql.mapper.CrudMapper;
import com.blossom.site.manager.entity.DataParamsDo;

/**
 * @author Blossom
 * @Description 数据库参数mapper操作
 * @time 2017/3/30 22:49
 */
@MyBatisDao
public interface DataParamsMapper extends CrudMapper<DataParamsDo>{
}
