package com.blossom.site.log.service.impl;

import com.blossom.site.base.lump.ErrorCodeLump;
import com.blossom.site.base.utils.JsonUtils;
import com.blossom.site.base.utils.LoggerUtils;
import com.blossom.site.common.servcie.AbstractCrudService;
import com.blossom.site.log.dao.SystemLogDao;
import com.blossom.site.log.entity.SystemLogDo;
import com.blossom.site.log.service.SystemLogService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description
 * @time 2017/3/24 14:42
 */
@Service
@Transactional
public class SystemLogServiceImpl extends AbstractCrudService implements SystemLogService {

    private static final Class<?> CLASS = SystemLogServiceImpl.class;

    @Autowired
    private SystemLogDao systemLogDaoImpl;

    /**
     * @param pJson
     * @description 获取系统日志信息
     * @author Blossom
     * @DateTime 2017/3/24 14:41
     */
    @Override
    public JSONObject listEntityInfo(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLASS,"listSystemLog",pJson.toString());
        try{
            Map<String,Object> map = new HashMap<>();
            List<SystemLogDo> systemLogDos = systemLogDaoImpl.listEntity(map);
            return JsonUtils.sealedSuccessJSON(null,"systemLogs",systemLogDos);
        }catch (Exception e){
            return ErrorCodeLump.exception(CLASS,"listSystemLog",e);
        }
    }
}
