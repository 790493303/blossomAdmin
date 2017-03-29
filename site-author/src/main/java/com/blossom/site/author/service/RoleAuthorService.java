package com.blossom.site.author.service;

import com.blossom.site.common.servcie.CrudService;
import net.sf.json.JSONObject;

/**
 * @author Blossom
 * @Description 角色权限service 接口
 * @time 2017/3/26 17:52
 */
public interface RoleAuthorService extends CrudService{

    /**
     * @description 获取用户所有权限列表
     * @author Blossom
     * @DateTime 2017/3/26 18:16
     * @param pJson
     */
    JSONObject findUserAuthor(JSONObject pJson);
}
