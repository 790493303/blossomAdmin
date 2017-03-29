package com.blossom.site.common.persistence.sql.dao;

import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description crud操作Dao
 * @time 2017/3/24 10:31
 */
public interface CrudDao<T> {

    /**
     * @description 插入数据
     * @author Blossom
     * @DateTime 2017/3/24 10:09
     * @param entity
     */
    int saveEntity(T entity);

    /**
     * @description 批量添加数据
     * @author Blossom
     * @DateTime 2017/3/24 10:11
     * @param list
     */
    int saveBathEntity(List<T> list);

    /**
     * @description 获取单条数据
     * @author Blossom
     * @DateTime 2017/3/24 10:18
     * @param key
     */
    T getEntity(String key);

    /**
     * @description 获取单条数据
     * @author Blossom
     * @DateTime 2017/3/24 10:19
     * @param entity
     */
    T getEntity(T entity);

    /**
     * @description 获取单条数据
     * @author Blossom
     * @DateTime 2017/3/24 10:19
     * @param pMap
     */
    T getEntity(Map<String,Object> pMap);

    /**
     * @description 查询数据列表，如果需要分页，请设置分页对象，如：entity.setPage(new Page<T>());
     * @author Blossom
     * @DateTime 2017/3/24 10:21
     * @param entity
     */
    List<T> listEntity(T entity);

    /**
     * @description 获取所有查询列表
     * @author Blossom
     * @DateTime 2017/3/24 10:21
     * @param entity
     */
    List<T> listAllEntity(T entity);

    /**
     * @description 获取所有数据列表
     * @author Blossom
     * @DateTime 2017/3/24 10:22
     * @param
     */
    List<T> listEntity();

    /**
     * @description 获取所有数据
     * @author Blossom
     * @DateTime 2017/3/24 10:27
     * @param pMap
     */
    List<T> listEntity(Map<String,Object> pMap);

    /**
     * @description 根据标识符删除数据
     * @author Blossom
     * @DateTime 2017/3/24 10:13
     * @param key
     */
    int removeEntity(String key);

    /**
     * @description 根据对象删除数据
     * @author Blossom
     * @DateTime 2017/3/24 10:14
     * @param t
     */
    int removeEntity(T t);

    /**
     * @description 移除对象
     * @author Blossom
     * @DateTime 2017/3/24 10:34
     * @param pMap
     */
    int removeEntity(Map<String,Object> pMap);

    /**
     * @description 更新信息
     * @author Blossom
     * @DateTime 2017/3/24 10:16
     * @param entity
     */
    int updateEntity(T entity);

    /**
     * @description 更新数据
     * @author Blossom
     * @DateTime 2017/3/24 10:16
     * @param pMap
     */
    int updateEntity(Map<String,Object> pMap);

}
