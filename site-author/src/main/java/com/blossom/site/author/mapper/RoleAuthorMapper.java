package com.blossom.site.author.mapper;

import com.blossom.site.author.entity.AuthorDo;
import com.blossom.site.common.persistence.sql.annotation.MyBatisDao;
import com.blossom.site.common.persistence.sql.mapper.CrudMapper;

import java.util.List;

/**
 * @author Blossom
 * @Description
 * @time 2017/3/25 23:09
 */
@MyBatisDao
public interface RoleAuthorMapper extends CrudMapper {


    /**
     * @description 获取权限
     * @author Blossom
     * @DateTime 2017/3/26 18:34
     * @param
     */
    List<AuthorDo> listAuthorByRoleIds(List<String> list);

}
