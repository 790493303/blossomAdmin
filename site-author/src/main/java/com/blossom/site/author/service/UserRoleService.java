package com.blossom.site.author.service;

import com.blossom.site.common.servcie.CrudService;
import net.sf.json.JSONObject;

/**
 * @author Blossom
 * @Description 用户角色service接口
 * @time 2017/3/26 18:06
 */
public interface UserRoleService extends CrudService {

    /**
     * @description 获取用户角色名列表
     * @author Blossom
     * @DateTime 2017/3/26 18:45
     * @param
     */
    JSONObject findUserRoleName(JSONObject pJson);
}
