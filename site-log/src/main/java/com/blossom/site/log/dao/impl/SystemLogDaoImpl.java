package com.blossom.site.log.dao.impl;

import com.blossom.site.common.persistence.sql.dao.AbstractCrudDao;
import com.blossom.site.log.dao.SystemLogDao;
import com.blossom.site.log.entity.SystemLogDo;
import com.blossom.site.log.mapper.SystemLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description
 * @time 2017/3/24 14:33
 */
@Repository
public class SystemLogDaoImpl extends AbstractCrudDao<SystemLogDo> implements SystemLogDao {

    @Autowired
    private SystemLogMapper systemLogMapper;

    /**
     * @param pMap
     * @description 获取所有数据
     * @author Blossom
     * @DateTime 2017/3/24 10:27
     */
    @Override
    public List<SystemLogDo> listEntity(Map<String, Object> pMap) {
        return systemLogMapper.listEntity(pMap);
    }
}
