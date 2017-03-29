package com.blossom.site.author.service.impl;

import com.blossom.site.author.dao.UserRoleDao;
import com.blossom.site.author.entity.RoleDo;
import com.blossom.site.author.service.UserRoleService;
import com.blossom.site.base.lump.ErrorCodeLump;
import com.blossom.site.base.utils.CollectionUtils;
import com.blossom.site.base.utils.JsonUtils;
import com.blossom.site.base.utils.LoggerUtils;
import com.blossom.site.common.servcie.AbstractCrudService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author Blossom
 * @Description 用户角色service接口实现
 * @time 2017/3/26 18:06
 */
@Service
@Transactional
public class UserRoleServiceImpl extends AbstractCrudService implements UserRoleService {

    private static final Class<?> CLASS = UserRoleServiceImpl.class;

    @Autowired
    private UserRoleDao userRoleDaoImpl;

    /**
     * @param pJson
     * @description 添加信息
     * @author Blossom
     * @DateTime 2017/3/26 14:14
     */
    @Override
    public JSONObject saveEntityInfo(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLASS,"saveEntityInfo",pJson.toString());
        try {
            if (JsonUtils.checkJSONIsNull(pJson) || JsonUtils.checkJSONKey(pJson,"roleId")
                    || JsonUtils.checkJSONKey(pJson,"userId")){
                return ErrorCodeLump.error(CLASS,"saveEntityInfo","参数不全!");
            }
            String roleId = pJson.getString("roleId");
            String userId = pJson.getString("userId");
            Map<String,Object> map = new HashMap<>();
            map.put("roleId",roleId);
            map.put("userId",userId);

            int intTag = userRoleDaoImpl.saveEntity(map);
            if (intTag == 0){
                return ErrorCodeLump.error(CLASS,"","添加失败!");
            }

            return JsonUtils.sealedSuccessJSON("添加成功!");

        }catch (Exception e){
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
    public JSONObject listEntityInfo(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLASS,"listEntityInfo",pJson.toString());
        try {
            if (JsonUtils.checkJSONIsNull(pJson) || JsonUtils.checkJSONKey(pJson,"longAccount")){
                return ErrorCodeLump.error(CLASS,"listEntityInfo","参数不全!");
            }
            String longAccount = pJson.getString("longAccount");
            Map<String,Object> map = new HashMap<>();
            map.put("longAccount",longAccount);

            List<RoleDo> roleDos = userRoleDaoImpl.listEntity(map);

            return JsonUtils.sealedSuccessJSON(null,"roles",roleDos);

        }catch (Exception e){
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
        try {
            if (JsonUtils.checkJSONIsNull(pJson) || JsonUtils.checkJSONKey(pJson,"userRoleId")){
                return ErrorCodeLump.error(CLASS,"removeEntityInfo","参数不全!");
            }
            String userRoleId = pJson.getString("userRoleId");
            Map<String,Object> map = new HashMap<>();
            map.put("userRoleId",userRoleId);
            int intTag = userRoleDaoImpl.removeEntity(map);
            if (intTag == 0){
                return ErrorCodeLump.error(CLASS,"removeEntityInfo","删除失败!");
            }

            return JsonUtils.sealedSuccessJSON("删除成功!");

        }catch (Exception e){
            return ErrorCodeLump.exception(CLASS,"removeEntityInfo",e);
        }
    }

    /**
     * @param pJson
     * @description 获取用户角色名列表
     * @author Blossom
     * @DateTime 2017/3/26 18:45
     */
    @Override
    public JSONObject findUserRoleName(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLASS,"findUserRoleName",pJson.toString());
        try {
            if (JsonUtils.checkJSONIsNull(pJson) || JsonUtils.checkJSONKey(pJson,"longAccount")){
                return ErrorCodeLump.error(CLASS,"findUserRoleName","参数不全!");
            }
            String longAccount = pJson.getString("longAccount");
            Map<String,Object> map = new HashMap<>();
            map.put("longAccount",longAccount);

            List<RoleDo> roleDos = userRoleDaoImpl.listEntity(map);
            Set<String> roleNameSet = new HashSet<>();
            if (!CollectionUtils.isEmpty(roleDos)){
                for (RoleDo roleDo : roleDos){
                    roleNameSet.add(roleDo.getRoleName());
                }
            }

            return JsonUtils.sealedSuccessJSON(null,"roleNames",roleNameSet);

        }catch (Exception e){
            return ErrorCodeLump.exception(CLASS,"findUserRoleName",e);
        }
    }
}
