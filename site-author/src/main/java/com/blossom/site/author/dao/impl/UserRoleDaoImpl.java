package com.blossom.site.author.dao.impl;

import com.blossom.site.author.dao.UserRoleDao;
import com.blossom.site.author.mapper.UserRoleMapper;
import com.blossom.site.common.persistence.sql.annotation.MyBatisDao;
import com.blossom.site.common.persistence.sql.dao.AbstractCrudDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description 用户角色Dao接口实现
 * @time 2017/3/26 12:12
 */
@MyBatisDao
public class UserRoleDaoImpl extends AbstractCrudDao implements UserRoleDao {

    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
     * @param entity
     * @description 插入数据
     * @author Blossom
     * @DateTime 2017/3/24 10:09
     */
    @Override
    public int saveEntity(Object entity) {
        return userRoleMapper.save(entity);
    }

    /**
     * @param pMap
     * @description 获取所有数据
     * @author Blossom
     * @DateTime 2017/3/24 10:27
     */
    @Override
    public List listEntity(Map pMap) {
        return userRoleMapper.listEntity(pMap);
    }

    /**
     * @param pMap
     * @description 移除对象
     * @author Blossom
     * @DateTime 2017/3/24 10:34
     */
    @Override
    public int removeEntity(Map pMap) {
        return userRoleMapper.removeEntity(pMap);
    }
}
