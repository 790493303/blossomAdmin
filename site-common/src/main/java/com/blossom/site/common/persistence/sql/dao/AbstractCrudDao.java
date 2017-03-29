package com.blossom.site.common.persistence.sql.dao;

import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description crud Dao接口抽象实现类
 * @time 2017/3/24 11:57
 */
public abstract class AbstractCrudDao<T> implements CrudDao<T>{
    /**
     * @param entity
     * @description 插入数据
     * @author Blossom
     * @DateTime 2017/3/24 10:09
     */
    @Override
    public int saveEntity(T entity) {
        return 0;
    }

    /**
     * @param list
     * @description 批量添加数据
     * @author Blossom
     * @DateTime 2017/3/24 10:11
     */
    @Override
    public int saveBathEntity(List<T> list) {
        return 0;
    }

    /**
     * @param key
     * @description 获取单条数据
     * @author Blossom
     * @DateTime 2017/3/24 10:18
     */
    @Override
    public T getEntity(String key) {
        return null;
    }

    /**
     * @param entity
     * @description 获取单条数据
     * @author Blossom
     * @DateTime 2017/3/24 10:19
     */
    @Override
    public T getEntity(T entity) {
        return null;
    }

    /**
     * @param pMap
     * @description 获取单条数据
     * @author Blossom
     * @DateTime 2017/3/24 10:19
     */
    @Override
    public T getEntity(Map<String, Object> pMap) {
        return null;
    }

    /**
     * @param entity
     * @description 查询数据列表，如果需要分页，请设置分页对象，如：entity.setPage(new Page<T>());
     * @author Blossom
     * @DateTime 2017/3/24 10:21
     */
    @Override
    public List<T> listEntity(T entity) {
        return null;
    }

    /**
     * @param entity
     * @description 获取所有查询列表
     * @author Blossom
     * @DateTime 2017/3/24 10:21
     */
    @Override
    public List<T> listAllEntity(T entity) {
        return null;
    }

    /**
     * @description 获取所有数据列表
     * @author Blossom
     * @DateTime 2017/3/24 10:22
     */
    @Override
    public List<T> listEntity() {
        return null;
    }

    /**
     * @param pMap
     * @description 获取所有数据
     * @author Blossom
     * @DateTime 2017/3/24 10:27
     */
    @Override
    public List<T> listEntity(Map<String, Object> pMap) {
        return null;
    }

    /**
     * @param key
     * @description 根据标识符删除数据
     * @author Blossom
     * @DateTime 2017/3/24 10:13
     */
    @Override
    public int removeEntity(String key) {
        return 0;
    }

    /**
     * @param t
     * @description 根据对象删除数据
     * @author Blossom
     * @DateTime 2017/3/24 10:14
     */
    @Override
    public int removeEntity(T t) {
        return 0;
    }

    /**
     * @param pMap
     * @description 移除对象
     * @author Blossom
     * @DateTime 2017/3/24 10:34
     */
    @Override
    public int removeEntity(Map<String, Object> pMap) {
        return 0;
    }

    /**
     * @param entity
     * @description 更新信息
     * @author Blossom
     * @DateTime 2017/3/24 10:16
     */
    @Override
    public int updateEntity(T entity) {
        return 0;
    }

    /**
     * @param pMap
     * @description 更新数据
     * @author Blossom
     * @DateTime 2017/3/24 10:16
     */
    @Override
    public int updateEntity(Map<String, Object> pMap) {
        return 0;
    }
}
