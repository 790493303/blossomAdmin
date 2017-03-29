package com.blossom.site.author.dao;

import com.blossom.site.author.entity.AuthorDo;
import com.blossom.site.common.persistence.sql.dao.CrudDao;

import java.util.List;

/**
 * @author Blossom
 * @Description 角色权限Dao接口
 * @time 2017/3/25 23:29
 */
public interface RoleAuthorDao extends CrudDao {

    /**
     * @description 批量获取权限
     * @author Blossom
     * @DateTime 2017/3/26 18:41
     * @param
     */
    List<AuthorDo> listAuthorByRoleIds(List<String> roleIds);
}
