package com.blossom.site.author.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;


/**
 * @author Blossom
 * @Description Shiro权限权限标签(Velocity版)
 * @time 2017/3/28 15:20
 */
public class VelocityShiro {

    /**
     * @description 是否拥有该权限
     * @author Blossom
     * @DateTime 2017/3/28 15:22
     * @param permission 权限标识
     * @return  true: 是  false : 否
     */
    public boolean hasPermission(String permission){
        Subject subject = SecurityUtils.getSubject();
        return subject != null && subject.isPermitted(permission);
    }

}
