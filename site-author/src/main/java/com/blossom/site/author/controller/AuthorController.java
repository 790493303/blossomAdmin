package com.blossom.site.author.controller;

import com.blossom.site.author.service.AuthorService;
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
 * @Description 权限API
 * @time 2017/3/27 16:48
 */
@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorServiceImpl;

    /**
     * @description 添加权限
     * @author Blossom
     * @DateTime 2017/3/27 17:10
     * @param
     */
    @RequestMapping("/save")
    @ResponseBody
    public JSONObject saveAuthor(@RequestParam() String authorName,
                                 @RequestParam() String description,
                                 @RequestParam() String url,
                                 @RequestParam() String parentAuthorId,
                                 HttpServletRequest request,
                                 HttpServletResponse response){
        JSONObject json = new JSONObject();

        json.put("authorName",authorName);
        json.put("description",description);
        json.put("url",url);
        json.put("parentAuthorId",parentAuthorId);

        json = authorServiceImpl.saveEntityInfo(json);

        return json;
    }

    /**
     * @description 获取单个权限对象信息
     * @author Blossom
     * @DateTime 2017/3/27 17:12
     * @param
     */
    @RequestMapping("/get")
    @ResponseBody
    public JSONObject getAuthor(@RequestParam(required = false, defaultValue = "") String authorId,
                                @RequestParam(required = false, defaultValue = "") String authorName,
                                HttpServletRequest request,
                                HttpServletResponse response){

        JSONObject json = new JSONObject();

        json.put("authorId", authorId);
        json.put("authorName",authorName);

        json = authorServiceImpl.getEntityInfo(json);

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
    public JSONObject listAuthorInfo(HttpServletRequest request,
                                   HttpServletResponse response){

        JSONObject json = new JSONObject();

        json = authorServiceImpl.listEntityInfo(json);

        return json;

    }

    /**
     * @description 删除权限
     * @author Blossom
     * @DateTime 2017/3/27 17:18
     * @param
     */
    @RequestMapping("/remove")
    @ResponseBody
    public JSONObject removeAuthor(@RequestParam() String authorId,
                                   HttpServletResponse response,
                                   HttpServletRequest request){

        JSONObject json = new JSONObject();

        json.put("authorId",authorId);

        json = authorServiceImpl.removeEntityInfo(json);

        return json;
    }
}
