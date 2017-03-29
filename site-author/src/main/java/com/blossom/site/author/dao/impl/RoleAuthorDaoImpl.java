package com.blossom.site.author.dao.impl;

import com.blossom.site.author.dao.RoleAuthorDao;
import com.blossom.site.author.entity.AuthorDo;
import com.blossom.site.author.mapper.RoleAuthorMapper;
import com.blossom.site.common.persistence.sql.annotation.MyBatisDao;
import com.blossom.site.common.persistence.sql.dao.AbstractCrudDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description 角色权限Dao接口实现
 * @time 2017/3/26 12:09
 */
@MyBatisDao
public class RoleAuthorDaoImpl extends AbstractCrudDao implements RoleAuthorDao{

    @Autowired
    private RoleAuthorMapper roleAuthorMapper;

    /**
     * @param entity
     * @description 插入数据
     * @author Blossom
     * @DateTime 2017/3/24 10:09
     */
    @Override
    public int saveEntity(Object entity) {
        return roleAuthorMapper.save(entity);
    }

    /**
     * @param pMap
     * @description 获取所有数据
     * @author Blossom
     * @DateTime 2017/3/24 10:27
     */
    @Override
    public List listEntity(Map pMap) {
        return roleAuthorMapper.listEntity(pMap);
    }

    /**
     * @param pMap
     * @description 移除对象
     * @author Blossom
     * @DateTime 2017/3/24 10:34
     */
    @Override
    public int removeEntity(Map pMap) {
        return roleAuthorMapper.removeEntity(pMap);
    }

    /**
     * @param roleIds
     * @description 批量获取权限
     * @author Blossom
     * @DateTime 2017/3/26 18:41
     */
    @Override
    public List<AuthorDo> listAuthorByRoleIds(List<String> roleIds) {
        return roleAuthorMapper.listAuthorByRoleIds(roleIds);
    }
}
