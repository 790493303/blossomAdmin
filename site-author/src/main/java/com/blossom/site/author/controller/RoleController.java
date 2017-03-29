package com.blossom.site.author.controller;

import com.blossom.site.author.service.RoleService;
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
 * @Description 角色API
 * @time 2017/3/27 16:19
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleServiceImpl;

    /**
     * @description 添加角色信息
     * @author Blossom
     * @DateTime 2017/3/27 16:24
     * @param
     */
    @RequestMapping("/save")
    @ResponseBody
    public JSONObject saveRoleInfo(@RequestParam() String roleName,
                                   @RequestParam() String parentRoleId,
                                   @RequestParam() String description,
                                   HttpServletRequest request,
                                   HttpServletResponse response){

        JSONObject json = new JSONObject();

        json.put("roleName",roleName);
        json.put("description",description);
        json.put("parentRoleId",parentRoleId);

        json = roleServiceImpl.saveEntityInfo(json);

        return json;
    }

    /**
     * @description 获取单个角色对象信息
     * @author Blossom
     * @DateTime 2017/3/27 16:37
     * @param
     */
    @RequestMapping("/get")
    @ResponseBody
    public JSONObject getRoleInfo(@RequestParam(required = false, defaultValue = "") String roleId,
                                  @RequestParam(required = false, defaultValue = "") String roleName,
                                  HttpServletResponse response,
                                  HttpServletRequest request){

        JSONObject json = new JSONObject();

        json.put("roleId",roleId);
        json.put("roleName",roleName);

        json = roleServiceImpl.getEntityInfo(json);

        return json;

    }

    /**
     * @description 获取角色列表
     * @author Blossom
     * @DateTime 2017/3/27 16:41
     * @param
     */
    @RequestMapping("/list")
    @ResponseBody
    public JSONObject listRoleInfo(HttpServletRequest request,
                                   HttpServletResponse response){

        JSONObject json = new JSONObject();

        json = roleServiceImpl.listEntityInfo(json);

        return json;

    }

    /**
     * @description 删除角色
     * @author Blossom
     * @DateTime 2017/3/27 16:45
     * @param
     */
    @RequestMapping("/remove")
    @ResponseBody
    public JSONObject removeRoleInfo(@RequestParam() String roleId,
                                     HttpServletRequest request,
                                     HttpServletResponse response){

        JSONObject json = new JSONObject();

        json.put("roleId",roleId);

        json = roleServiceImpl.removeEntityInfo(json);

        return json;
    }

}
