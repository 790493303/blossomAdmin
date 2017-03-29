package com.blossom.site.common.persistence.sql.mapper;

import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description Crud 操作mapper实现
 * @time 2017/3/24 10:37
 */
public interface CrudMapper<T> {

    /**
     * @description 添加数据
     * @author Blossom
     * @DateTime 2017/3/24 10:38
     * @param entity
     */
    int save(T entity);

    /**
     * @description 添加数据
     * @author Blossom
     * @DateTime 2017/3/24 10:42
     * @param pMap
     */
    int saveEntity(Map<String,Object> pMap);

    /**
     * @description 批量添加数据
     * @author Blossom
     * @DateTime 2017/3/24 10:39
     * @param list
     */
    int saveBathEntity(List<T> list);

    /**
     * @description 删除数据
     * @author Blossom
     * @DateTime 2017/3/24 10:41
     * @param key
     */
    int removeEntityByKey(String key);

    /**
     * @description 删除数据
     * @author Blossom
     * @DateTime 2017/3/24 10:41
     * @param pMap
     */
    int removeEntity(Map<String,Object> pMap);

    /**
     * @description 更新数据
     * @author Blossom
     * @DateTime 2017/3/24 10:43
     * @param entity
     */
    int update(T entity);

    /**
     * @description 更新数据
     * @author Blossom
     * @DateTime 2017/3/24 10:43
     * @param pMap
     */
    int updateEntity(Map<String,Object> pMap);

    /**
     * @description 获取一条数据
     * @author Blossom
     * @DateTime 2017/3/24 10:43
     * @param key
     */
    T getEntityByKey(String key);

    /**
     * @description 获取一条数据
     * @author Blossom
     * @DateTime 2017/3/24 10:44
     * @param pMap
     */
    T getEntity(Map<String,Object> pMap);

    /**
     * @description 获取数据列表
     * @author Blossom
     * @DateTime 2017/3/24 10:48
     * @param pMap
     */
    List<T> listEntity(Map<String,Object> pMap);

}
