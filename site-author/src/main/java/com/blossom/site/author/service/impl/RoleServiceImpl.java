package com.blossom.site.author.service.impl;

import com.blossom.site.author.dao.RoleDao;
import com.blossom.site.author.entity.RoleDo;
import com.blossom.site.author.service.RoleService;
import com.blossom.site.base.lump.ErrorCodeLump;
import com.blossom.site.base.utils.DateUtils;
import com.blossom.site.base.utils.JsonUtils;
import com.blossom.site.base.utils.LoggerUtils;
import com.blossom.site.base.utils.ObjectUtils;
import com.blossom.site.common.servcie.AbstractCrudService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description 角色Service接口实现
 * @time 2017/3/26 14:07
 */
@Service
@Transactional
public class RoleServiceImpl extends AbstractCrudService implements RoleService{

    private static final Class CLASS = RoleServiceImpl.class;

    @Autowired
    private RoleDao roleDaoImpl;

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
            String roleName = pJson.getString("roleName");
            JSONObject json = new JSONObject();
            json.put("roleName",roleName);
            json = getEntityInfo(json);
            if (json.getInt("status") == 1){
                return ErrorCodeLump.error(CLASS,"saveEntityInfo","此角色已存在!");
            }

            int parentRoleId = pJson.getInt("parentRoleId");
            Timestamp createTime = DateUtils.dateToTimestamp(DateUtils.format());
            String description = pJson.getString("description");

            RoleDo role = new RoleDo();
            role.setCreateTime(createTime);
            role.setParentRoleId(parentRoleId);
            role.setRoleDescription(description);
            role.setRoleName(roleName);

            int intTag = roleDaoImpl.saveEntity(role);
            if (intTag == 0){
                return ErrorCodeLump.error(CLASS,"saveEntityInfo","添加失败!");
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
    public JSONObject getEntityInfo(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLASS,"getEntityInfo",pJson.toString());
        try{
            if (JsonUtils.checkJSONIsNull(pJson)){
                return ErrorCodeLump.error(CLASS,"getEntityInfo","参数不全!");
            }
            Map<String,Object> map = new HashMap<>();
            String roleId = null;
            if (!JsonUtils.checkJSONKey(pJson,"roleId")){
                roleId = pJson.getString("roleId");
            }
            map.put("roleId",roleId);

            String roleName = null;
            if (!JsonUtils.checkJSONKey(pJson,"roleName")){
                roleName = pJson.getString("roleName");
            }
            map.put("roleName",roleName);

            RoleDo role = roleDaoImpl.getEntity(map);
            if (ObjectUtils.isEmpty(role)){
                return ErrorCodeLump.error(CLASS,"getEntityInfo","角色不存在!");
            }

            return JsonUtils.sealedSuccessJSON("","role",role);

        }catch (Exception e){
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
        LoggerUtils.addLoggerInfo(CLASS,"listEntityInfo",pJson.toString());
        try {
            Map<String,Object> map = new HashMap<>();
            List<RoleDo> roleDos = roleDaoImpl.listEntity(map);
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
        try{
            if (JsonUtils.checkJSONIsNull(pJson) || JsonUtils.checkJSONKey(pJson,"roleId")){
                return ErrorCodeLump.error(CLASS,"removeEntityInfo","参数不全!");
            }
            String roleId = pJson.getString("roleId");
            Map<String,Object> map = new HashMap<>();
            map.put("roleId",roleId);
            int intTag = roleDaoImpl.removeEntity(map);
            if (intTag == 0){
                return ErrorCodeLump.error(CLASS,"removeEntityInfo","删除失败!");
            }

            return JsonUtils.sealedSuccessJSON("删除成功!");

        }catch (Exception e){
            return ErrorCodeLump.exception(CLASS,"removeEntityInfo",e);
        }
    }
}
