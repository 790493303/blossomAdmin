package com.blossom.site.author.service;

import com.blossom.site.common.servcie.CrudService;
import net.sf.json.JSONObject;

/**
 * @author Blossom
 * @Description 用户service接口
 * @time 2017/3/25 23:35
 */
public interface UserService extends CrudService{

    /**
     * @description 用户登录
     * @author Blossom
     * @DateTime 2017/3/26 12:25
     * @param pJson
     */
    JSONObject userLogin(JSONObject pJson);
}
