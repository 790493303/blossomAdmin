package com.blossom.site.log.dao.impl;

import com.blossom.site.common.persistence.sql.dao.AbstractCrudDao;
import com.blossom.site.log.dao.VisitLogDao;
import com.blossom.site.log.entity.VisitLogDo;
import com.blossom.site.log.mapper.VisitLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description 访问日志Dao接口实现类
 * @time 2017/3/24 10:59
 */
@Repository
public class VisitLogDaoImpl extends AbstractCrudDao<VisitLogDo> implements VisitLogDao{

    @Autowired
    private VisitLogMapper visitLogMapper;

    /**
     * @param entity
     * @description 插入数据
     * @author Blossom
     * @DateTime 2017/3/24 10:09
     */
    @Override
    public int saveEntity(VisitLogDo entity) {
        return visitLogMapper.save(entity);
    }

    /**
     * @param pMap
     * @description 获取所有数据
     * @author Blossom
     * @DateTime 2017/3/24 10:27
     */
    @Override
    public List<VisitLogDo> listEntity(Map<String, Object> pMap) {
        return visitLogMapper.listEntity(pMap);
    }
}
