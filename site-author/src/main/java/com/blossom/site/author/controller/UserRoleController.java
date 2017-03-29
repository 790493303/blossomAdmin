package com.blossom.site.author.controller;

import com.blossom.site.author.service.UserRoleService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Blossom
 * @Description 用户角色API
 * @time 2017/3/27 17:21
 */
@Controller
@RequestMapping("/userRole")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleServiceImpl;

    /**
     * @description 添加用户角色
     * @author Blossom
     * @DateTime 2017/3/27 17:23
     * @param
     */
    @RequestMapping("/save")
    @ResponseBody
    public JSONObject saveUseRole(@RequestParam() String userId,
                                  @RequestParam() String roleId,
                                  HttpServletRequest request,
                                  HttpServletResponse response){
        JSONObject json = new JSONObject();

        json.put("userId",userId);
        json.put("roleId",roleId);

        json = userRoleServiceImpl.saveEntityInfo(json);

        return json;
    }

    /**
     * @description 用户角色列表
     * @author Blossom
     * @DateTime 2017/3/27 17:26
     * @param
     */
    @RequestMapping("/list")
    @ResponseBody
    public JSONObject listUserRole(@RequestParam() String longAccount,
                                   HttpServletRequest request,
                                   HttpServletResponse response){

        JSONObject json = new JSONObject();

        json.put("longAccount",longAccount);

        json = userRoleServiceImpl.listEntityInfo(json);

        return json;
    }

    /**
     * @description 删除用户角色
     * @author Blossom
     * @DateTime 2017/3/27 17:27
     * @param
     */
    @RequestMapping("/remove")
    @ResponseBody
    public JSONObject removeUserRole(@RequestParam() String userRoleId,
                                     HttpServletRequest request,
                                     HttpServletResponse response){

        JSONObject json = new JSONObject();

        json.put("userRoleId",userRoleId);

        json = userRoleServiceImpl.removeEntityInfo(json);

        return json;
    }

}
