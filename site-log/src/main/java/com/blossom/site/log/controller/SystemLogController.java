package com.blossom.site.log.controller;

import com.blossom.site.log.annotation.VisitLog;
import com.blossom.site.log.service.SystemLogService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Blossom
 * @Description 系统日志API
 * @time 2017/3/24 16:48
 */
@Controller
@RequestMapping("/systemLog")
public class SystemLogController {

    @Autowired
    private SystemLogService systemLogServiceImpl;

    /**
     * @description 获取系统日志列表
     * @author Blossom
     * @DateTime 2017/3/24 16:50
     * @param
     */
    @RequestMapping("/list")
    @ResponseBody
    @VisitLog(description = "系统日志列表")
    public JSONObject listSystemLog(){
        JSONObject json = new JSONObject();
        json = systemLogServiceImpl.listEntityInfo(json);
        return json;
    }

}
