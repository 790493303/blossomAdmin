package com.blossom.site.author.service.impl;

import com.blossom.site.author.dao.RoleAuthorDao;
import com.blossom.site.author.entity.AuthorDo;
import com.blossom.site.author.service.RoleAuthorService;
import com.blossom.site.base.lump.ErrorCodeLump;
import com.blossom.site.base.utils.CollectionUtils;
import com.blossom.site.base.utils.JsonUtils;
import com.blossom.site.base.utils.LoggerUtils;
import com.blossom.site.base.utils.StringUtils;
import com.blossom.site.common.servcie.AbstractCrudService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author Blossom
 * @Description 角色权限service接口实现
 * @time 2017/3/26 17:53
 */
@Service
@Transactional
public class RoleAuthorServiceImpl extends AbstractCrudService implements RoleAuthorService{

    private static final Class<?> CLASS = RoleAuthorServiceImpl.class;

    @Autowired
    private RoleAuthorDao roleAuthorDaoImpl;

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
                    || JsonUtils.checkJSONKey(pJson,"authorId")){
                return ErrorCodeLump.error(CLASS,"saveEntityInfo","参数不全!");
            }
            String roleId = pJson.getString("roleId");
            String authorId = pJson.getString("authorId");
            Map<String,Object> map = new HashMap<>();
            map.put("roleId",roleId);
            map.put("authorId",authorId);

            int intTag = roleAuthorDaoImpl.saveEntity(map);
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
            if (JsonUtils.checkJSONIsNull(pJson) || JsonUtils.checkJSONKey(pJson,"roleId")){
                return ErrorCodeLump.error(CLASS,"listEntityInfo","参数不全!");
            }
            String roleId = pJson.getString("roleId");
            Map<String,Object> map = new HashMap<>();
            map.put("roleId",roleId);

            List<AuthorDo> authorDos = roleAuthorDaoImpl.listEntity(map);

            return JsonUtils.sealedSuccessJSON(null,"authors",authorDos);

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
            if (JsonUtils.checkJSONIsNull(pJson) || JsonUtils.checkJSONKey(pJson,"roleAuthorId")){
                return ErrorCodeLump.error(CLASS,"removeEntityInfo","参数不全!");
            }
            String roleAuthorId = pJson.getString("roleAuthorId");
            Map<String,Object> map = new HashMap<>();
            map.put("roleAuthorId",roleAuthorId);
            int intTag = roleAuthorDaoImpl.removeEntity(map);
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
     * @description 获取用户所有权限列表
     * @author Blossom
     * @DateTime 2017/3/26 18:16
     */
    @Override
    public JSONObject findUserAuthor(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLASS,"findUserAuthor",pJson.toString());
        try{
            if (JsonUtils.checkJSONIsNull(pJson) || JsonUtils.checkJSONKey(pJson,"roleIds")){
                return ErrorCodeLump.error(CLASS,"findUserAuthor","参数不全!");
            }

            String roleIds = pJson.getString("roleIds");
            String[] roleIdArray = StringUtils.split(roleIds,",");
            List<String> roleIdList = Arrays.asList(roleIdArray);
            Set<String> authorNameSet = new HashSet<>();
            List<AuthorDo> authorDos = roleAuthorDaoImpl.listAuthorByRoleIds(roleIdList);
            if (!CollectionUtils.isEmpty(authorDos)){
                for(AuthorDo authorDo : authorDos){
                    authorNameSet.add(authorDo.getAuthorName());
                }
            }
            return JsonUtils.sealedSuccessJSON(null,"authorNames",authorNameSet);
        }catch (Exception e){
            return ErrorCodeLump.exception(CLASS,"findUserAuthor",e);
        }
    }
}
