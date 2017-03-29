package com.blossom.site.author.dao.impl;

import com.blossom.site.author.dao.RoleDao;
import com.blossom.site.author.entity.RoleDo;
import com.blossom.site.author.mapper.RolesMapper;
import com.blossom.site.common.persistence.sql.annotation.MyBatisDao;
import com.blossom.site.common.persistence.sql.dao.AbstractCrudDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description 角色Dao接口实现
 * @time 2017/3/26 11:47
 */
@MyBatisDao
public class RoleDaoImpl extends AbstractCrudDao<RoleDo> implements RoleDao{

    @Autowired
    private RolesMapper rolesMapper;

    /**
     * @param entity
     * @description 插入数据
     * @author Blossom
     * @DateTime 2017/3/24 10:09
     */
    @Override
    public int saveEntity(RoleDo entity) {
        return rolesMapper.save(entity);
    }

    /**
     * @param pMap
     * @description 获取单条数据
     * @author Blossom
     * @DateTime 2017/3/24 10:19
     */
    @Override
    public RoleDo getEntity(Map<String, Object> pMap) {
        return rolesMapper.getEntity(pMap);
    }

    /**
     * @description 获取所有数据列表
     * @author Blossom
     * @DateTime 2017/3/24 10:22
     */
    @Override
    public List<RoleDo> listEntity() {
        Map<String,Object> map = new HashMap<>();
        return rolesMapper.listEntity(map);
    }

    /**
     * @param pMap
     * @description 获取所有数据
     * @author Blossom
     * @DateTime 2017/3/24 10:27
     */
    @Override
    public List<RoleDo> listEntity(Map<String, Object> pMap) {
        return rolesMapper.listEntity(pMap);
    }

    /**
     * @param pMap
     * @description 移除对象
     * @author Blossom
     * @DateTime 2017/3/24 10:34
     */
    @Override
    public int removeEntity(Map<String, Object> pMap) {
        return rolesMapper.removeEntity(pMap);
    }

}
