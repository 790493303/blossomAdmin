package com.blossom.site.author.dao.impl;

import com.blossom.site.author.dao.UserDao;
import com.blossom.site.author.entity.UserDo;
import com.blossom.site.author.mapper.UserMapper;
import com.blossom.site.common.persistence.sql.dao.AbstractCrudDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description 用户Dao接口实现
 * @time 2017/3/25 23:30
 */
@Repository
public class UserDaoImpl extends AbstractCrudDao<UserDo> implements UserDao{

    @Autowired
    private UserMapper userMapper;

    /**
     * @param entity
     * @description 插入数据
     * @author Blossom
     * @DateTime 2017/3/24 10:09
     */
    @Override
    public int saveEntity(UserDo entity) {
        return userMapper.save(entity);
    }

    /**
     * @param pMap
     * @description 获取单条数据
     * @author Blossom
     * @DateTime 2017/3/24 10:19
     */
    @Override
    public UserDo getEntity(Map<String, Object> pMap) {
        return userMapper.getEntity(pMap);
    }

    /**
     * @description 获取所有数据列表
     * @author Blossom
     * @DateTime 2017/3/24 10:22
     */
    @Override
    public List<UserDo> listEntity() {
        Map<String,Object> map = new HashMap<>();
        return userMapper.listEntity(map);
    }

    /**
     * @param pMap
     * @description 获取所有数据
     * @author Blossom
     * @DateTime 2017/3/24 10:27
     */
    @Override
    public List<UserDo> listEntity(Map<String, Object> pMap) {
        return userMapper.listEntity(pMap);
    }

    /**
     * @param pMap
     * @description 移除对象
     * @author Blossom
     * @DateTime 2017/3/24 10:34
     */
    @Override
    public int removeEntity(Map<String, Object> pMap) {
        return userMapper.removeEntity(pMap);
    }

    /**
     * @param pMap
     * @description 更新数据
     * @author Blossom
     * @DateTime 2017/3/24 10:16
     */
    @Override
    public int updateEntity(Map<String, Object> pMap) {
        return userMapper.updateEntity(pMap);
    }
}
