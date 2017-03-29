package com.blossom.site.author.service.impl;

import com.blossom.site.author.dao.UserDao;
import com.blossom.site.author.entity.UserDo;
import com.blossom.site.author.service.UserService;
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
import java.util.Map;

/**
 * @author Blossom
 * @Description 用户service接口实现
 * @time 2017/3/25 23:35
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractCrudService implements UserService{

    private static final Class CLASS = UserServiceImpl.class;

    @Autowired
    private UserDao userDaoImpl;

    /**
     * @param pJson
     * @description 获取用户详细信息
     * @author Blossom
     * @DateTime 2017/3/26 12:21
     */
    @Override
    public JSONObject getEntityInfo(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLASS,"getUserInfo",pJson.toString());
        try{
            if(JsonUtils.checkJSONIsNull(pJson)){
                return ErrorCodeLump.error(CLASS,"getUserInfo","参数不全!");
            }
            Map<String,Object> map = new HashMap<>();
            String loginAccount = null;
            if (!JsonUtils.checkJSONKey(pJson,"loginAccount")){
                loginAccount = pJson.getString("loginAccount");
            }
            map.put("loginAccount",loginAccount);

            String userName = null;
            if (!JsonUtils.checkJSONKey(pJson,"userName")){
                userName = pJson.getString("userName");
            }
            map.put("userName",userName);

            String telephone = null;
            if (!JsonUtils.checkJSONKey(pJson,"telephone")){
                telephone = pJson.getString("telephone");
            }
            map.put("telephone",telephone);
            String email = null;
            if (!JsonUtils.checkJSONKey(pJson,"email")){
                email = pJson.getString("email");
            }
            map.put("email",email);

            UserDo user = userDaoImpl.getEntity(map);
            if (ObjectUtils.isEmpty(user)){
                return ErrorCodeLump.error(CLASS,"getUserInfo","此信息不存在!");
            }

            return JsonUtils.sealedSuccessJSON(null,"user",user);

        }catch (Exception e){
           return ErrorCodeLump.exception(CLASS,"getUserInfo",e);
        }
    }

    /**
     * @param pJson
     * @description 添加用户
     * @author Blossom
     * @DateTime 2017/3/26 12:22
     */
    @Override
    public JSONObject saveEntityInfo(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLASS,"saveUserInfo",pJson.toString());
        try{
            if (JsonUtils.checkJSONIsNull(pJson)){
                return ErrorCodeLump.error(CLASS,"saveUserInfo","参数不全!");
            }
            int organizationId = pJson.getInt("organizationId");
            String loginAccount = pJson.getString("longAccount");
            String loginPassword = pJson.getString("longPassword");
            String userName = pJson.getString("userName");
            String telephone = pJson.getString("telephone");
            String email = pJson.getString("email");
            Timestamp createTime = DateUtils.dateToTimestamp(DateUtils.format());

            JSONObject json = new JSONObject();
            json.put("loginAccount",loginAccount);
            json = getEntityInfo(json);
            if (json.getInt("status") == 1){
                return ErrorCodeLump.error(CLASS,"saveEntityInfo","此账号已存在!");
            }
            json.clear();
            json.put("userName",userName);
            json = getEntityInfo(json);
            if (json.getInt("status") == 1){
                return ErrorCodeLump.error(CLASS,"saveEntityInfo","用户名已存在!");
            }
            json.clear();
            json.put("telephone",telephone);
            json = getEntityInfo(json);
            if (json.getInt("status") == 1){
                return ErrorCodeLump.error(CLASS,"saveEntityInfo","此号码已存在!");
            }
            json.clear();
            json.put("email",email);
            json = getEntityInfo(json);
            if (json.getInt("status") == 1){
                return ErrorCodeLump.error(CLASS,"saveEntityInfo","此邮箱已存在!");
            }

            UserDo userDo = new UserDo();
            userDo.setOrganizationId(organizationId);
            userDo.setUserName(userName);
            userDo.setLoginAccount(loginAccount);
            userDo.setLoginPassword(loginPassword);
            userDo.setTelephone(telephone);
            userDo.setEmail(email);
            userDo.setCreateTime(createTime);

            int intTag = userDaoImpl.saveEntity(userDo);
            if (intTag == 0){
                return ErrorCodeLump.error(CLASS,"saveUserInfo","添加失败!");
            }

            return JsonUtils.sealedSuccessJSON("添加成功!");

        }catch (Exception e){
            return ErrorCodeLump.exception(CLASS,"saveUserInfo",e);
        }
    }

    /**
     * @param pJson
     * @description 更新用户信息
     * @author Blossom
     * @DateTime 2017/3/26 12:23
     */
    @Override
    public JSONObject updateEntityInfo(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLASS,"updateUserInfo",pJson.toString());
        try{
            if (JsonUtils.checkJSONIsNull(pJson) || JsonUtils.checkJSONKey(pJson,"userId")){
                return ErrorCodeLump.error(CLASS,"updateUserInfo","参数不全!");
            }
            Map<String,Object> map = new HashMap<>();
            String userId = pJson.getString("userId");
            map.put("userId",userId);

            JSONObject json = null;
            String loginAccount = null;
            if (!JsonUtils.checkJSONKey(pJson,"loginAccount")){
                loginAccount = pJson.getString("loginAccount");
                json = new JSONObject();
                json.put("loginAccount",loginAccount);
                json = getEntityInfo(json);
                if (json.getInt("status") == 1){
                    return ErrorCodeLump.error(CLASS,"saveEntityInfo","此账号已存在!");
                }
            }
            map.put("loginAccount",loginAccount);

            String loginPassword = null;
            if (!JsonUtils.checkJSONKey(pJson,"loginPassword")){
                loginPassword = pJson.getString("loginPassword");
            }
            map.put("loginPassword",loginPassword);

            String userName = null;
            if (!JsonUtils.checkJSONKey(pJson,"userName")){
                userName = pJson.getString("userName");
                json = new JSONObject();
                json.put("userName",userName);
                json = getEntityInfo(json);
                if (json.getInt("status") == 1){
                    return ErrorCodeLump.error(CLASS,"saveEntityInfo","用户名已存在!");
                }
            }
            map.put("userName",userName);

            String telephone = null;
            if (!JsonUtils.checkJSONKey(pJson,"telephone")){
                telephone = pJson.getString("telephone");
                json = new JSONObject();
                json.put("telephone",telephone);
                json = getEntityInfo(json);
                if (json.getInt("status") == 1){
                    return ErrorCodeLump.error(CLASS,"saveEntityInfo","此号码已存在!");
                }
            }
            map.put("telephone",telephone);
            String email = null;
            if (!JsonUtils.checkJSONKey(pJson,"email")){
                email = pJson.getString("mail");
                json = new JSONObject();
                json.put("email",email);
                json = getEntityInfo(json);
                if (json.getInt("status") == 1){
                    return ErrorCodeLump.error(CLASS,"saveEntityInfo","此邮箱已存在!");
                }
            }
            map.put("email",email);

            String loginTime = null;
            if (!JsonUtils.checkJSONKey(pJson,"loginTime")){
                loginTime =  pJson.getString("loginTime");
            }
            map.put("loginTime",loginTime);

            String lastLoginTime = null;
            if (!JsonUtils.checkJSONKey(pJson,"lastLoginTime")){
                lastLoginTime = pJson.getString("lastLoginTime");
            }
            map.put("lastLoginTime",lastLoginTime);

            String loginCount = null;
            if(!JsonUtils.checkJSONKey(pJson,"loginCount")){
                loginCount = pJson.getString("loginCount");
            }
            map.put("loginCount",loginCount);

            int intTag = userDaoImpl.updateEntity(map);
            if (intTag == 0){
                return ErrorCodeLump.error(CLASS,"updateUserInfo","修改失败!");
            }

            return JsonUtils.sealedSuccessJSON("修改成功!");
        }catch (Exception e){
            return ErrorCodeLump.exception(CLASS,"updateUserInfo",e);
        }
    }

    /**
     * @param pJson
     * @description 删除用户信息
     * @author Blossom
     * @DateTime 2017/3/26 12:24
     */
    @Override
    public JSONObject removeEntityInfo(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLASS,"removeUserInfo",pJson.toString());
        try{
            if (JsonUtils.checkJSONIsNull(pJson) || JsonUtils.checkJSONKey(pJson,"userId")){
                return ErrorCodeLump.error(CLASS,"removeUserInfo","参数不全!");
            }
            String userId = pJson.getString("userId");
            Map<String,Object> map = new HashMap<>();
            map.put("userId",userId);
            int intTag = userDaoImpl.removeEntity(map);
            if (intTag == 0){
                return ErrorCodeLump.error(CLASS,"removeUserInfo","删除失败!");
            }
            return JsonUtils.sealedSuccessJSON("删除成功!");
        }catch (Exception e){
            return ErrorCodeLump.exception(CLASS,"removeUserInfo",e);
        }
    }

    /**
     * @param pJson
     * @description 用户登录
     * @author Blossom
     * @DateTime 2017/3/26 12:25
     */
    @Override
    public JSONObject userLogin(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLASS,"userLogin",pJson.toString());
        try{
            if (JsonUtils.checkJSONIsNull(pJson) || JsonUtils.checkJSONKey(pJson,"loginAccount")
                    || JsonUtils.checkJSONKey(pJson,"loginPassword")){
                return ErrorCodeLump.error(CLASS,"userLogin","参数不全!");
            }
            String loginPassword = pJson.getString("loginPassword");
            JSONObject json = getEntityInfo(pJson);
            if (json.getInt("status") == 0 || json.getInt("status") == -1){
                return json;
            }
            UserDo user = (UserDo)JSONObject.toBean(json.getJSONObject("user"),UserDo.class);
            if (!loginPassword.equals(user.getLoginPassword())){
                return ErrorCodeLump.error(CLASS,"userLogin","密码错误!");
            }
            json.clear();

            //登录成功后修改登录时间，最后一次登录时间，登录次数等信息
            Timestamp loginTime = DateUtils.dateToTimestamp(DateUtils.format());
            Timestamp lastLoginTime = DateUtils.dateToTimestamp(DateUtils.format());
            int loginCount = user.getLoginCount() + 1;

            user.setLoginTime(loginTime);
            user.setLoginCount(loginCount);
            user.setLastLoginTime(lastLoginTime);

            json.put("loginTime",loginTime);
            json.put("lastLoginTime",lastLoginTime);
            json.put("loginCount",loginCount);

            updateEntityInfo(json);

            return JsonUtils.sealedSuccessJSON("登录成功!","user",user);
        }catch (Exception e){
            return ErrorCodeLump.exception(CLASS,"userLogin",e);
        }
    }
}
