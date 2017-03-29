package com.blossom.site.log.service.impl;

import com.blossom.site.base.lump.ErrorCodeLump;
import com.blossom.site.base.utils.DateUtils;
import com.blossom.site.base.utils.JsonUtils;
import com.blossom.site.base.utils.LoggerUtils;
import com.blossom.site.common.servcie.AbstractCrudService;
import com.blossom.site.log.dao.HandleLogDao;
import com.blossom.site.log.entity.HandleLogDo;
import com.blossom.site.log.service.HandleLogService;
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
 * @Description
 * @time 2017/3/24 14:45
 */
@Service
@Transactional
public class HandleLogServiceImpl extends AbstractCrudService implements HandleLogService {

    private static final Class<?> CLASS = HandleLogServiceImpl.class;

    @Autowired
    private HandleLogDao handleLogDaoImpl;

    /**
     * @param pJson
     * @description 添加操作日志
     * @author Blossom
     * @DateTime 2017/3/24 14:44
     */
    @Override
    public JSONObject saveEntityInfo(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLASS,"saveHandleLog",pJson.toString());
        try{
            if (JsonUtils.checkJSONIsNull(pJson)){
                return ErrorCodeLump.error(CLASS,"saveHandleLog","参数不全!");
            }
            String description = pJson.getString("description");
            Timestamp handleTime = DateUtils.dateToTimestamp(DateUtils.format());
            int type = pJson.getInt("type");
            String userName = pJson.getString("userName");

            HandleLogDo handleLog = new HandleLogDo();
            handleLog.setDescription(description);
            handleLog.setHandleTime(handleTime);
            handleLog.setType(type);
            handleLog.setUserName(userName);

            int intTag = handleLogDaoImpl.saveEntity(handleLog);
            if (intTag == 0){
                return ErrorCodeLump.error(CLASS,"saveHandleLog","添加失败!");
            }

            LoggerUtils.addLoggerInfo(CLASS,"saveHandleLog","添加成功!");
            return JsonUtils.sealedSuccessJSON("添加成功!");

        }catch (Exception e){
            return ErrorCodeLump.exception(CLASS,"saveHandleLog",e);
        }
    }



    /**
     * @param pJson
     * @description 获取操作日志
     * @author Blossom
     * @DateTime 2017/3/24 14:45
     */
    @Override
    public JSONObject listEntityInfo(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLASS,"listHandleLog",pJson.toString());
        try{
            Map<String,Object> map = new HashMap<>();
            List<HandleLogDo> handleLogDos = handleLogDaoImpl.listEntity(map);
            return JsonUtils.sealedSuccessJSON(null,"handleLogs",handleLogDos);
        }catch (Exception e){
            return ErrorCodeLump.exception(CLASS,"listHandleLog",e);
        }
    }
}
