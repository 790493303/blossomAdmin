package com.blossom.site.author.service.impl;

import com.blossom.site.author.dao.AuthorDao;
import com.blossom.site.author.entity.AuthorDo;
import com.blossom.site.author.service.AuthorService;
import com.blossom.site.base.lump.ErrorCodeLump;
import com.blossom.site.base.utils.JsonUtils;
import com.blossom.site.base.utils.LoggerUtils;
import com.blossom.site.base.utils.ObjectUtils;
import com.blossom.site.common.servcie.AbstractCrudService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description 权限service接口实现
 * @time 2017/3/26 15:05
 */
@Service
@Transactional
public class AuthorServiceImpl extends AbstractCrudService implements AuthorService{

    private static final Class<?> CLASS = AuthorServiceImpl.class;

    @Autowired
    private AuthorDao authorDaoImpl;

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
            if (JsonUtils.checkJSONIsNull(pJson) || JsonUtils.checkJSONKey(pJson,"authorName")){
                return ErrorCodeLump.error(CLASS,"saveEntityInfo","参数不全!");
            }
            String authorName = pJson.getString("authorName");
            JSONObject json = new JSONObject();
            json.put("authorName",authorName);
            json = getEntityInfo(json);
            if (json.getInt("status") == 1){
                return ErrorCodeLump.error(CLASS,"saveEntityInfo","此权限以及存在!");
            }
            json.clear();

            String authorDescription = pJson.getString("description");
            String authorUrl = pJson.getString("url");
            int parentAuthorId = pJson.getInt("parentAuthorId");

            AuthorDo authorDo = new AuthorDo();
            authorDo.setAuthorDescription(authorDescription);
            authorDo.setAuthorName(authorName);
            authorDo.setAuthorUrl(authorUrl);
            authorDo.setParentAuthorId(parentAuthorId);

            int intTag = authorDaoImpl.saveEntity(authorDo);

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
        try {
            if (JsonUtils.checkJSONIsNull(pJson)){
                return ErrorCodeLump.error(CLASS,"getEntityInfo","参数不全!");
            }
            Map<String,Object> map = new HashMap<>();
            String authorId = null;
            if (JsonUtils.checkJSONKey(pJson,"authorId")){
                authorId = pJson.getString("authorId");
            }
            map.put("authorId",authorId);

            String authorName = null;
            if (JsonUtils.checkJSONKey(pJson,"authorName")){
                authorName = pJson.getString("authorName");
            }
            map.put("authorName",authorName);

            AuthorDo author = authorDaoImpl.getEntity(map);
            if (ObjectUtils.isEmpty(author)){
                return ErrorCodeLump.error(CLASS,"getEntityInfo","参数错误!");
            }

            return JsonUtils.sealedSuccessJSON(null,"author",author);

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
            List<AuthorDo> authorDos = authorDaoImpl.listEntity(map);
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
            if (JsonUtils.checkJSONIsNull(pJson) || JsonUtils.checkJSONKey(pJson,"authorId")){
                return ErrorCodeLump.error(CLASS,"removeEntityInfo","参数不全!");
            }
            String authorId = pJson.getString("authorId");
            Map<String,Object> map = new HashMap<>();
            map.put("authorId",authorId);
            int intTag = authorDaoImpl.removeEntity(map);
            if (intTag == 0){
                return ErrorCodeLump.error(CLASS,"removeEntityInfo","删除失败!");
            }
            return JsonUtils.sealedSuccessJSON("删除成功!");
        }catch (Exception e){
            return ErrorCodeLump.exception(CLASS,"removeEntityInfo",e);
        }
    }
}
