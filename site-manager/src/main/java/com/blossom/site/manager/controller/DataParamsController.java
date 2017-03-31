package com.blossom.site.manager.controller;

import com.blossom.site.manager.service.DataParamsService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Blossom
 * @Description 数据库连接参数API
 * @time 2017/3/31 14:31
 */
@Controller
@RequestMapping("/dataParams")
public class DataParamsController {

    @Autowired
    private DataParamsService dataParamsServiceImpl;

    /**
     * @description 添加参数
     * @author Blossom
     * @DateTime 2017/3/31 14:33
     * @param
     */
    @RequestMapping("/save")
    @ResponseBody
    public JSONObject saveDataParams(@RequestParam() String address,
                                     @RequestParam() String name,
                                     @RequestParam() String type,
                                     @RequestParam() String password,
                                     @RequestParam() String port,
                                     @RequestParam() String userName){

        JSONObject json = new JSONObject();

        json.put("address",address);
        json.put("name",name);
        json.put("type",type);
        json.put("password",password);
        json.put("port",port);
        json.put("userName",userName);

        json = dataParamsServiceImpl.saveEntityInfo(json);

        return json;
    }

    /**
     * @description 删除参数信息(物理删除，逻辑删除)
     * @author Blossom
     * @DateTime 2017/3/31 14:40
     * @param
     */
    @RequestMapping("/remove")
    @ResponseBody
    public JSONObject removeDataParams(@RequestParam() String id,
                                       @RequestParam(required = false, defaultValue = "") String status){

        JSONObject json = new JSONObject();
        json.put("id",id);
        if ("".equals(status)) { //物理删除
            json = dataParamsServiceImpl.removeEntityInfo(json);
        }else { //逻辑删除
            json.put("status", status);
            json = dataParamsServiceImpl.updateEntityInfo(json);
        }

        return json;
    }

    /**
     * @description 获取单个对象信息
     * @author Blossom
     * @DateTime 2017/3/31 14:42
     * @param
     */
    @RequestMapping("/get")
    @ResponseBody
    public JSONObject getDataParams(@RequestParam() String id){

        JSONObject json = new JSONObject();
        json.put("id",id);

        json = dataParamsServiceImpl.getEntityInfo(json);

        return json;
    }

    /**
     * @description 获取对象列表
     * @author Blossom
     * @DateTime 2017/3/31 14:43
     * @param
     */
    @RequestMapping("/list")
    @ResponseBody
    public JSONObject listDataParams(){
        JSONObject json = new JSONObject();

        json = dataParamsServiceImpl.listEntityInfo(json);

        return json;
    }

}
