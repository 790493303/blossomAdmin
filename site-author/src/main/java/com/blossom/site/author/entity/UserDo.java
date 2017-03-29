package com.blossom.site.author.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Blossom
 * @Description 用户实体
 * @time 2017/3/25 21:27
 */
public class UserDo implements Serializable{

    private static final long serialVersionUID = -9164179179540181995L;

    private Integer userId;
    private Integer organizationId;
    private String loginAccount;
    private String loginPassword;
    private String userName;
    private String telephone;
    private String email;
    private Timestamp createTime;
    private Timestamp loginTime;
    private Timestamp lastLoginTime;
    private Integer loginCount;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    @Override
    public String toString() {
        return "UserDo{" +
                "userId=" + userId +
                ", organizationId=" + organizationId +
                ", longAccount='" + loginAccount + '\'' +
                ", longPassword='" + loginPassword + '\'' +
                ", userName='" + userName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                ", loginTime=" + loginTime +
                ", lastLoginTime=" + lastLoginTime +
                ", loginCount=" + loginCount +
                '}';
    }
}
