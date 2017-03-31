package com.blossom.site.log.controller;

import com.blossom.site.log.annotation.VisitLog;
import com.blossom.site.log.service.HandleLogService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Blossom
 * @Description 操作日志API
 * @time 2017/3/24 16:44
 */
@Controller
@RequestMapping("/handleLog")
public class HandleLogController {

    @Autowired
    private HandleLogService handleLogServiceImpl;

    /**
     * @description 获取操作日志列表
     * @author Blossom
     * @DateTime 2017/3/24 16:47
     * @param
     */
    @RequestMapping("/list")
    @ResponseBody
    @VisitLog(description = "操作日志列表")
    public JSONObject listHandleLog(){
        JSONObject json = new JSONObject();
        json = handleLogServiceImpl.saveEntityInfo(json);
        return json;
    }

}
