package com.blossom.site.log.service.impl;

import com.blossom.site.base.lump.ErrorCodeLump;
import com.blossom.site.base.utils.JsonUtils;
import com.blossom.site.base.utils.LoggerUtils;
import com.blossom.site.common.servcie.AbstractCrudService;
import com.blossom.site.log.annotation.HandleLog;
import com.blossom.site.log.dao.VisitLogDao;
import com.blossom.site.log.entity.VisitLogDo;
import com.blossom.site.log.service.VisitLogService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description 访问日志service接口实现
 * @time 2017/3/24 11:50
 */
@Service
@Transactional
public class VisitLogServiceImpl extends AbstractCrudService implements VisitLogService {

    private static final Class<?> CLASS = VisitLogServiceImpl.class;

    @Autowired
    private VisitLogDao visitLogDaoImpl;

    /**
     * @param pJson
     * @description 添加访问日志信息
     * @author Blossom
     * @DateTime 2017/3/24 11:51
     */
    @Override
    @HandleLog(description = "insert",tableName = "tb_visit_log")
    public JSONObject saveEntityInfo(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLASS,"saveVisitLog",pJson.toString());
        try{
            if(JsonUtils.checkJSONIsNull(pJson)){
                return ErrorCodeLump.error(CLASS,"saveVisitLog","参数不全!");
            }
            String broswer = pJson.getString("broswer");
            String createBy = pJson.getString("createBy");
            String createDate = pJson.getString("createDate");
            String description = pJson.getString("description");
            String httpMethod = pJson.getString("httpMethod");
            String method = pJson.getString("method");
            String params = pJson.getString("params");
            String requestIp = pJson.getString("requestIp");
            String url = pJson.getString("url");

            VisitLogDo visitLog = new VisitLogDo();
            visitLog.setBroswer(broswer);
            visitLog.setCreateBy(createBy);
            visitLog.setCreateDate(createDate);
            visitLog.setDescription(description);
            visitLog.setHttpMethod(httpMethod);
            visitLog.setMethod(method);
            visitLog.setParams(params);
            visitLog.setRequestIp(requestIp);
            visitLog.setUrl(url);

            int intTag = visitLogDaoImpl.saveEntity(visitLog);

            if (intTag == 0){
               return ErrorCodeLump.error(CLASS,"saveVisitLog","添加失败!");
            }
            LoggerUtils.addLoggerDebug(CLASS,"saveVisitLog","添加成功!");
            return JsonUtils.sealedSuccessJSON("添加成功!");

        }catch (Exception e){
            return ErrorCodeLump.exception(CLASS,"saveVisitLog",e);
        }
    }

    /**
     * @param pJson
     * @description 获取访问日志信息
     * @author Blossom
     * @DateTime 2017/3/24 11:52
     */
    @Override
    public JSONObject listEntityInfo(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLASS,"listVisitLog",pJson.toString());
        try{
            /*if(JsonUtils.checkJSONIsNull(pJson)){
                return ErrorCodeLump.error(CLASS,"listVisitLog","参数不全!");
            }*/

            Map<String,Object> map = new HashMap<>();

            List<VisitLogDo> visitLogDos = visitLogDaoImpl.listEntity(map);

            return JsonUtils.sealedSuccessJSON(null,"visitLogs",visitLogDos);

        }catch (Exception e){
            return ErrorCodeLump.exception(CLASS,"listVisitLog",e);
        }
    }
}
