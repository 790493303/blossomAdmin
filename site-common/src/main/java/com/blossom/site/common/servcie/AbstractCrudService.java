package com.blossom.site.common.servcie;

import net.sf.json.JSONObject;

/**
 * @author Blossom
 * @Description crud service接口抽象实现类
 * @time 2017/3/26 14:17
 */
public abstract class AbstractCrudService implements CrudService{
    /**
     * @param pJson
     * @description 添加信息
     * @author Blossom
     * @DateTime 2017/3/26 14:14
     */
    @Override
    public JSONObject saveEntityInfo(JSONObject pJson) {
        return null;
    }

    /**
     * @param pJson
     * @description 获取实体信息
     * @author Blossom
     * @DateTime 2017/3/26 14:15
     */
    @Override
    public JSONObject getEntityInfo(JSONObject pJson) {
        return null;
    }

    /**
     * @param pJson
     * @description 获取实体信息
     * @author Blossom
     * @DateTime 2017/3/26 14:15
     */
    @Override
    public JSONObject listEntityInfo(JSONObject pJson) {
        return null;
    }

    /**
     * @param pJson
     * @description 删除实体信息
     * @author Blossom
     * @DateTime 2017/3/26 14:16
     */
    @Override
    public JSONObject removeEntityInfo(JSONObject pJson) {
        return null;
    }

    /**
     * @param pJson
     * @description 修改实体信息
     * @author Blossom
     * @DateTime 2017/3/26 14:16
     */
    @Override
    public JSONObject updateEntityInfo(JSONObject pJson) {
        return null;
    }
}
