package com.blossom.site.log.controller;

import com.blossom.site.log.annotation.VisitLog;
import com.blossom.site.log.service.VisitLogService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Blossom
 * @Description 访问日志API
 * @time 2017/3/24 16:37
 */
@Controller
@RequestMapping("/visitLog")
public class VisitLogController {

    @Autowired
    private VisitLogService visitLogServiceImpl;

    /**
     * @description 访问日志列表
     * @author Blossom
     * @DateTime 2017/3/24 16:39
     * @param
     */
    @RequestMapping("/list")
    @ResponseBody
    @VisitLog(description = "获取访问日志列表")
    public JSONObject listVisitLog(){
        JSONObject json = new JSONObject();
        json = visitLogServiceImpl.listEntityInfo(json);
        return json;
    }

}
