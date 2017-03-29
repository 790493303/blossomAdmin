package com.blossom.site.author.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Blossom
 * @Description 角色实体
 * @time 2017/3/25 21:31
 */
public class RoleDo implements Serializable {


    private static final long serialVersionUID = 1023113819411165171L;

    private Integer roleId;
    private Integer parentRoleId;
    private String roleName;
    private Timestamp createTime;
    private String roleDescription;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getParentRoleId() {
        return parentRoleId;
    }

    public void setParentRoleId(Integer parentRoleId) {
        this.parentRoleId = parentRoleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    @Override
    public String toString() {
        return "RoleDo{" +
                "roleId=" + roleId +
                ", parentRoleId=" + parentRoleId +
                ", roleName='" + roleName + '\'' +
                ", createTime=" + createTime +
                ", roleDescription='" + roleDescription + '\'' +
                '}';
    }
}
