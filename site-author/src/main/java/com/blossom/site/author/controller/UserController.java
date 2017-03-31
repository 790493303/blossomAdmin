package com.blossom.site.author.controller;

import com.blossom.site.author.entity.UserDo;
import com.blossom.site.author.service.UserService;
import com.blossom.site.author.util.ShiroUtils;
import com.blossom.site.base.utils.JsonUtils;
import net.sf.json.JSONObject;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Blossom
 * @Description 用户API
 * @time 2017/3/26 15:08
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userServiceImpl;

    /**
     * @description 获取单个用户信息
     * @author Blossom
     * @DateTime 2017/3/26 18:49
     * @param
     */
    @RequestMapping("/get")
    @ResponseBody
    public JSONObject getUserInfo(@RequestParam(required = false, defaultValue = "") String loginAccount,
                                  @RequestParam(required = false, defaultValue = "") String userName,
                                  @RequestParam(required = false, defaultValue = "") String telephone,
                                  @RequestParam(required = false, defaultValue = "") String email){
        JSONObject json = new JSONObject();
        json.put("loginAccount",loginAccount);
        json.put("userName",userName);
        json.put("telephone",telephone);
        json.put("email",email);
        json = userServiceImpl.getEntityInfo(json);

        return json;
    }

    /**
     * @description 获取用户列表
     * @author Blossom
     * @DateTime 2017/3/26 18:50
     * @param
     */
    @RequestMapping("/list")
    @ResponseBody
    public JSONObject listUserInfo(){

        JSONObject json = new JSONObject();
        json = userServiceImpl.listEntityInfo(json);
        return json;
    }

    /**
     * @description 用户登录
     * @author Blossom
     * @DateTime 2017/3/27 15:35
     * @param
     */
    @RequestMapping("/login")
    @ResponseBody
    public JSONObject loginUserInfo(@RequestParam() String loginAccount,
                                    @RequestParam() String loginPassword,
                                    @RequestParam(required = false, defaultValue = "") String vilateCode,
                                    HttpServletRequest request,
                                    HttpServletResponse response){

        HttpSession session = request.getSession();

        JSONObject json = new JSONObject();
        json.put("loginAccount",loginAccount);
        json.put("loginPassword",loginPassword);

        json = userServiceImpl.userLogin(json);

        UserDo userDo = (UserDo)JSONObject.toBean(json.getJSONObject("user"),UserDo.class);

        if (json.getInt("status") == 1){
            session.setAttribute("userName",userDo.getLoginAccount());
            session.setAttribute("user",userDo);
        }

        Subject subject = ShiroUtils.getSubject();
        loginPassword = new Sha256Hash(loginPassword).toHex();
        UsernamePasswordToken token = new UsernamePasswordToken(loginAccount,loginPassword);
        subject.login(token);

        return json;
    }

    /**
     * @description 添加用户信息
     * @author Blossom
     * @DateTime 2017/3/27 15:46
     * @param
     */
    @RequestMapping("/save")
    @ResponseBody
    public JSONObject saveUserInfo(@RequestParam() String loginAccount,
                                   @RequestParam() String loginPassword,
                                   @RequestParam() String userName,
                                   @RequestParam() String telephone,
                                   @RequestParam() String email,
                                   @RequestParam() String organizationId){
        JSONObject json = new JSONObject();
        json.put("loginAccount",loginAccount);
        json.put("userName",userName);
        json.put("telephone",telephone);
        json.put("email",email);
        json.put("loginPassword",loginPassword);
        json.put("organizationId",organizationId);

        json = userServiceImpl.saveEntityInfo(json);

        return json;
    }

    /**
     * @description 修改用户信息
     * @author Blossom
     * @DateTime 2017/3/27 15:50
     * @param
     */
    @RequestMapping("/update")
    @ResponseBody
    public JSONObject updateUserInfo(@RequestParam(required = false, defaultValue = "") String loginAccount,
                                     @RequestParam(required = false, defaultValue = "") String loginPassword,
                                     @RequestParam(required = false, defaultValue = "") String userName,
                                     @RequestParam(required = false, defaultValue = "") String telephone,
                                     @RequestParam(required = false, defaultValue = "") String email,
                                     @RequestParam() String userId){
        JSONObject json = new JSONObject();
        json.put("userId",userId);
        json.put("loginAccount",loginAccount);
        json.put("userName",userName);
        json.put("telephone",telephone);
        json.put("email",email);
        json.put("loginPassword",loginPassword);

        json = userServiceImpl.updateEntityInfo(json);

        return json;
    }

    /**
     * @description 删除用户
     * @author Blossom
     * @DateTime 2017/3/27 16:02
     * @param
     */
    @RequestMapping("/remove")
    @ResponseBody
    public JSONObject removeUserInfo(@RequestParam() String userId){

        JSONObject json = new JSONObject();
        json.put("userId",userId);

        json = userServiceImpl.removeEntityInfo(json);

        return json;
    }

    /**
     * @description 退出登录
     * @author Blossom
     * @DateTime 2017/3/27 16:06
     * @param
     */
    @RequestMapping("/exit")
    @ResponseBody
    public JSONObject exitLoginUser(@RequestParam(required = false, defaultValue = "") String loginAccount,
                                    HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();

        session.removeAttribute("userName");
        session.removeAttribute("user");

        ShiroUtils.logout();

        return JsonUtils.sealedSuccessJSON("退出登录!");
    }

}
