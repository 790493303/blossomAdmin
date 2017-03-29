package com.blossom.site.author.util;

import com.blossom.site.author.entity.UserDo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;


/**
 * @author Blossom
 * @Description Shiro工具类
 * @time 2017/3/28 15:14
 */
public class ShiroUtils {

    public static Session getSession(){
        return SecurityUtils.getSubject().getSession();
    }

    public static Subject getSubject(){
        return SecurityUtils.getSubject();
    }

    public static UserDo getUserEntity(){
        return (UserDo)SecurityUtils.getSubject().getPrincipal();
    }

    public static String getUserAccount(){
        return getUserEntity().getLoginAccount();
    }

    public static void setSessionAttribute(Object key,Object value){
        getSession().setAttribute(key, value);
    }

    public static Object getSessionAttribute(Object key) {
        return getSession().getAttribute(key);
    }

    public static boolean isLogin() {
        return SecurityUtils.getSubject().getPrincipal() != null;
    }

    public static void logout() {
        SecurityUtils.getSubject().logout();
    }

    public static String getKaptcha(String key) {
        String kaptcha = getSessionAttribute(key).toString();
        getSession().removeAttribute(key);
        return kaptcha;
    }
}
