package com.blossom.site.author.dao.impl;

import com.blossom.site.author.dao.AuthorDao;
import com.blossom.site.author.entity.AuthorDo;
import com.blossom.site.author.mapper.AuthorMapper;
import com.blossom.site.common.persistence.sql.annotation.MyBatisDao;
import com.blossom.site.common.persistence.sql.dao.AbstractCrudDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description 权限Dao接口实现
 * @time 2017/3/26 12:06
 */
@MyBatisDao
public class AuthorDaoImpl extends AbstractCrudDao<AuthorDo> implements AuthorDao{

    @Autowired
    private AuthorMapper authorMapper;

    /**
     * @param entity
     * @description 插入数据
     * @author Blossom
     * @DateTime 2017/3/24 10:09
     */
    @Override
    public int saveEntity(AuthorDo entity) {
        return authorMapper.save(entity);
    }

    /**
     * @param pMap
     * @description 获取单条数据
     * @author Blossom
     * @DateTime 2017/3/24 10:19
     */
    @Override
    public AuthorDo getEntity(Map<String, Object> pMap) {
        return authorMapper.getEntity(pMap);
    }

    /**
     * @description 获取所有数据列表
     * @author Blossom
     * @DateTime 2017/3/24 10:22
     */
    @Override
    public List<AuthorDo> listEntity() {
        Map<String,Object> map = new HashMap<>();
        return authorMapper.listEntity(map);
    }

    /**
     * @param pMap
     * @description 获取所有数据
     * @author Blossom
     * @DateTime 2017/3/24 10:27
     */
    @Override
    public List<AuthorDo> listEntity(Map<String, Object> pMap) {
        return authorMapper.listEntity(pMap);
    }

    /**
     * @param pMap
     * @description 移除对象
     * @author Blossom
     * @DateTime 2017/3/24 10:34
     */
    @Override
    public int removeEntity(Map<String, Object> pMap) {
        return authorMapper.removeEntity(pMap);
    }
}
