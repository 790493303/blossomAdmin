package com.blossom.site.manager.dao.impl;

import com.blossom.site.common.persistence.sql.dao.AbstractCrudDao;
import com.blossom.site.manager.dao.DataParamsDao;
import com.blossom.site.manager.entity.DataParamsDo;
import com.blossom.site.manager.mapper.DataParamsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description 数据库连接参数Dao接口实现
 * @time 2017/3/30 23:08
 */
@Repository
public class DataParamsDaoImpl extends AbstractCrudDao<DataParamsDo> implements DataParamsDao {

    @Autowired
    private DataParamsMapper dataParamsMapper;

    /**
     * @param entity
     * @description 插入数据
     * @author Blossom
     * @DateTime 2017/3/24 10:09
     */
    @Override
    public int saveEntity(DataParamsDo entity) {
        return dataParamsMapper.save(entity);
    }

    /**
     * @param pMap
     * @description 获取单条数据
     * @author Blossom
     * @DateTime 2017/3/24 10:19
     */
    @Override
    public DataParamsDo getEntity(Map<String, Object> pMap) {
        return dataParamsMapper.getEntity(pMap);
    }

    /**
     * @description 获取所有数据列表
     * @author Blossom
     * @DateTime 2017/3/24 10:22
     */
    @Override
    public List<DataParamsDo> listEntity() {
        Map<String,Object> map = new HashMap<>();
        return dataParamsMapper.listEntity(map);
    }

    /**
     * @param pMap
     * @description 获取所有数据
     * @author Blossom
     * @DateTime 2017/3/24 10:27
     */
    @Override
    public List<DataParamsDo> listEntity(Map<String, Object> pMap) {
        return dataParamsMapper.listEntity(pMap);
    }

    /**
     * @param pMap
     * @description 移除对象
     * @author Blossom
     * @DateTime 2017/3/24 10:34
     */
    @Override
    public int removeEntity(Map<String, Object> pMap) {
        return dataParamsMapper.removeEntity(pMap);
    }

    /**
     * @param pMap
     * @description 更新数据
     * @author Blossom
     * @DateTime 2017/3/24 10:16
     */
    @Override
    public int updateEntity(Map<String, Object> pMap) {
        return dataParamsMapper.updateEntity(pMap);
    }
}
