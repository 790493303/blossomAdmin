package com.blossom.site.manager.service.impl;

import com.blossom.site.base.lump.ErrorCodeLump;
import com.blossom.site.base.utils.JsonUtils;
import com.blossom.site.base.utils.LoggerUtils;
import com.blossom.site.base.utils.ObjectUtils;
import com.blossom.site.common.servcie.AbstractCrudService;
import com.blossom.site.manager.dao.DataParamsDao;
import com.blossom.site.manager.entity.DataParamsDo;
import com.blossom.site.manager.service.DataParamsService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description 数据库连接参数Service接口实现
 * @time 2017/3/30 23:14
 */
@Service
public class DataParamsServiceImpl extends AbstractCrudService implements DataParamsService {

    private static final Class<?> CLASS = DataParamsServiceImpl.class;

    @Autowired
    private DataParamsDao dataParamsDaoImpl;

    /**
     * @param pJson
     * @description 添加信息
     * @author Blossom
     * @DateTime 2017/3/26 14:14
     */
    @Override
    public JSONObject saveEntityInfo(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLASS,"saveEntityInfo",pJson.toString());
        try{
            if (JsonUtils.checkJSONIsNull(pJson)){
                return ErrorCodeLump.error(CLASS,"saveEntityInfo","参数不全!");
            }
            String address = pJson.getString("address");
            String name = pJson.getString("name");
            int type = pJson.getInt("type");
            String password = pJson.getString("password");
            String port = pJson.getString("port");
            String userName = pJson.getString("userName");



            //校验是否存在:如果存在status==1提示错误，否则直接修改status的值，如果不存在则添加
            Map<String,Object> map = new HashMap<>();
            map.put("dataAddress",address);
            map.put("dataName",name);
            map.put("dataType",type);
            map.put("password",password);
            map.put("port",port);
            map.put("userName",userName);

            DataParamsDo dataParamsDo = dataParamsDaoImpl.getEntity(map);
            if (ObjectUtils.isEmpty(dataParamsDo)){ //如果为null,表示不存在
                dataParamsDo = new DataParamsDo();
                dataParamsDo.setDataAddress(address);
                dataParamsDo.setDataName(name);
                dataParamsDo.setDataType(type);
                dataParamsDo.setPassword(password);
                dataParamsDo.setPort(port);
                dataParamsDo.setUserName(userName);

                int intTag = dataParamsDaoImpl.saveEntity(dataParamsDo);
                if (intTag == 0){
                    return ErrorCodeLump.error(CLASS,"saveEntityInfo","添加失败!");
                }

                return JsonUtils.sealedSuccessJSON("添加成功!");
            }
            //否则表示已经存在，判断status状态是否为1，如果为1返回错误，否则修改status状态值为1
            if (dataParamsDo.getStatus() == 1){
                return ErrorCodeLump.error(CLASS,"saveEntityInfo","此参数已存在!");
            }

            map.put("id",dataParamsDo.getId());
            map.put("status",1);
            int intTag = dataParamsDaoImpl.updateEntity(map);

            if (intTag == 0){
                return ErrorCodeLump.error(CLASS,"saveEntityInfo","添加失败!");
            }

            return JsonUtils.sealedSuccessJSON("添加成功!");

        }catch(Exception e){
            return ErrorCodeLump.exception(CLASS,"saveEntityInfo",e);
        }
    }

    /**
     * @param pJson
     * @description 获取实体信息
     * @author Blossom
     * @DateTime 2017/3/26 14:15
     */
    @Override
    public JSONObject getEntityInfo(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLASS ,"getEntityInfo",pJson);
        try{
            if (JsonUtils.checkJSONIsNull(pJson) || JsonUtils.checkJSONKey(pJson,"id")){
                return ErrorCodeLump.error(CLASS,"getEntityInfo","参数不全!");
            }
            String id = pJson.getString("id");
            Map<String,Object> map = new HashMap<>();
            map.put("id",id);
            DataParamsDo dataParamsDo = dataParamsDaoImpl.getEntity(map);
            if (ObjectUtils.isEmpty(dataParamsDo)){
                return ErrorCodeLump.error(CLASS,"getEntityInfo","参数错误!");
            }

            return JsonUtils.sealedSuccessJSON(null,"dataParams",dataParamsDo);
        }catch(Exception e){
            return ErrorCodeLump.exception(CLASS,"getEntityInfo",e);
        }
    }

    /**
     * @param pJson
     * @description 获取实体信息
     * @author Blossom
     * @DateTime 2017/3/26 14:15
     */
    @Override
    public JSONObject listEntityInfo(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLASS,"listEntityInfo",pJson);
        try{
            List<DataParamsDo> dataParamsDos = null;
            if (JsonUtils.checkJSONIsNull(pJson)){
                 dataParamsDos = dataParamsDaoImpl.listEntity();
            }else{
                Map<String,Object> map = new HashMap<>();
                dataParamsDos = dataParamsDaoImpl.listEntity(map);
            }

            return JsonUtils.sealedSuccessJSON(null,"dataParams",dataParamsDos);
        }catch(Exception e){
            return ErrorCodeLump.exception(CLASS,"listEntityInfo",e);
        }
    }

    /**
     * @param pJson
     * @description 删除实体信息
     * @author Blossom
     * @DateTime 2017/3/26 14:16
     */
    @Override
    public JSONObject removeEntityInfo(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLASS,"removeEntityInfo",pJson.toString());
        try{
            if (JsonUtils.checkJSONIsNull(pJson) || JsonUtils.checkJSONKey(pJson,"id")){
                return ErrorCodeLump.error(CLASS,"removeEntityInfo","参数不全!");
            }
            String id = pJson.getString("id");
            Map<String,Object> map = new HashMap<>();
            map.put("id",id);
            int intTag = dataParamsDaoImpl.removeEntity(map);
            if (intTag == 0){
                return ErrorCodeLump.error(CLASS,"removeEntityInfo","删除失败!");
            }
            return JsonUtils.sealedSuccessJSON("删除成功!");
        }catch(Exception e){
            return ErrorCodeLump.exception(CLASS,"removeEntityInfo",e);
        }
    }

    /**
     * @param pJson
     * @description 修改实体信息
     * @author Blossom
     * @DateTime 2017/3/26 14:16
     */
    @Override
    public JSONObject updateEntityInfo(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLASS,"updateEntityInfo",pJson);
        try{
            if (JsonUtils.checkJSONIsNull(pJson) || JsonUtils.checkJSONKey(pJson,"id")){
                return ErrorCodeLump.error(CLASS,"updateEntityInfo","参数不全!");
            }
            Map<String,Object> map = new HashMap<>();
            String id = pJson.getString("id");
            String status = pJson.getString("status");
            map.put("id",id);
            map.put("status",status);
            int intTag = dataParamsDaoImpl.updateEntity(map);
            if (intTag == 0){
                return ErrorCodeLump.error(CLASS,"updateEntityInfo","修改失败!");
            }

            return JsonUtils.sealedSuccessJSON("修改成功!");
        }catch(Exception e){
            return ErrorCodeLump.exception(CLASS,"updateEntityInfo",e);
        }
    }
}
