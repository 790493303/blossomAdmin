package com.blossom.site.common.servcie;

import net.sf.json.JSONObject;

/**
 * @author Blossom
 * @Description crud service接口
 * @time 2017/3/26 14:14
 */
public interface CrudService {

    /**
     * @description 添加信息
     * @author Blossom
     * @DateTime 2017/3/26 14:14
     * @param
     */
    JSONObject saveEntityInfo(JSONObject pJson);

    /**
     * @description 获取实体信息
     * @author Blossom
     * @DateTime 2017/3/26 14:15
     * @param
     */
    JSONObject getEntityInfo(JSONObject pJson);

    /**
     * @description 获取实体信息
     * @author Blossom
     * @DateTime 2017/3/26 14:15
     * @param
     */
    JSONObject listEntityInfo(JSONObject pJson);

    /**
     * @description 删除实体信息
     * @author Blossom
     * @DateTime 2017/3/26 14:16
     * @param
     */
    JSONObject removeEntityInfo(JSONObject pJson);

    /**
     * @description 修改实体信息
     * @author Blossom
     * @DateTime 2017/3/26 14:16
     * @param
     */
    JSONObject updateEntityInfo(JSONObject pJson);

}
