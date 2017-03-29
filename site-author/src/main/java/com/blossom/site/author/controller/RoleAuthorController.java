package com.blossom.site.author.controller;

import com.blossom.site.author.service.RoleAuthorService;
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
 * @Description 角色权限API
 * @time 2017/3/27 17:28
 */
@Controller
@RequestMapping("/roleAuthor")
public class RoleAuthorController {

    @Autowired
    private RoleAuthorService roleAuthorServiceImpl;

    /**
     * @description 添加角色权限
     * @author Blossom
     * @DateTime 2017/3/27 17:33
     * @param
     */
    @RequestMapping("/save")
    @ResponseBody
    public JSONObject saveRoleAuthor(@RequestParam() String roleId,
                                     @RequestParam() String authorId,
                                     HttpServletRequest request,
                                     HttpServletResponse response){

        JSONObject json = new JSONObject();

        json.put("roleId",roleId);
        json.put("authorId",authorId);

        json = roleAuthorServiceImpl.saveEntityInfo(json);

        return json;
    }

    /**
     * @description 角色权限列表
     * @author Blossom
     * @DateTime 2017/3/27 17:35
     * @param
     */
    @RequestMapping("/list")
    @ResponseBody
    public JSONObject listRoleAuthor(@RequestParam() String roleId,
                                     HttpServletRequest request,
                                     HttpServletResponse response){

        JSONObject json = new JSONObject();

        json.put("roleId",roleId);

        json = roleAuthorServiceImpl.listEntityInfo(json);

        return json;
    }

    /**
     * @description 删除角色权限
     * @author Blossom
     * @DateTime 2017/3/27 17:36
     * @param
     */
    @RequestMapping("/remove")
    @ResponseBody
    public JSONObject removeRoleAuthor(@RequestParam() String roleAuthorId,
                                       HttpServletRequest request,
                                       HttpServletResponse response){

        JSONObject json = new JSONObject();

        json.put("roleAuthorId",roleAuthorId);

        json = roleAuthorServiceImpl.removeEntityInfo(json);

        return json;
    }

}
