package com.blossom.site.log.dao.impl;

import com.blossom.site.common.persistence.sql.dao.AbstractCrudDao;
import com.blossom.site.log.dao.HandleLogDao;
import com.blossom.site.log.entity.HandleLogDo;
import com.blossom.site.log.mapper.HandleLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description
 * @time 2017/3/24 14:37
 */
@Repository
public class HandleLogDaoImpl extends AbstractCrudDao<HandleLogDo> implements HandleLogDao{

    @Autowired
    private HandleLogMapper handleLogMapper;

    /**
     * @param entity
     * @description 插入数据
     * @author Blossom
     * @DateTime 2017/3/24 10:09
     */
    @Override
    public int saveEntity(HandleLogDo entity) {
        return handleLogMapper.save(entity);
    }

    /**
     * @param pMap
     * @description 获取所有数据
     * @author Blossom
     * @DateTime 2017/3/24 10:27
     */
    @Override
    public List<HandleLogDo> listEntity(Map<String, Object> pMap) {
        return handleLogMapper.listEntity(pMap);
    }
}
