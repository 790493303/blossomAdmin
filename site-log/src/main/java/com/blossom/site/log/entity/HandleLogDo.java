package com.blossom.site.log.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Blossom
 * @Description 操作日志实体
 * @time 2017/3/23 18:03
 */
public class HandleLogDo implements Serializable{

    private static final long serialVersionUID = -160840114326711082L;

    private Integer id;
    private Timestamp handleTime;
    private Integer type;
    private String userName;
    private String description;
    private String tableName;
    private String params;

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Timestamp handleTime) {
        this.handleTime = handleTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "HandleLogDo{" +
                "id=" + id +
                ", handleTime=" + handleTime +
                ", type=" + type +
                ", userName='" + userName + '\'' +
                ", description='" + description + '\'' +
                ", tableName='" + tableName + '\'' +
                ", params='" + params + '\'' +
                '}';
    }
}
