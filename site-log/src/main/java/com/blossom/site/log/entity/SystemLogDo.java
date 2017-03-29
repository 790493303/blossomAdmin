package com.blossom.site.log.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Blossom
 * @Description 系统日志实体
 * @time 2017/3/23 18:02
 */
public class SystemLogDo implements Serializable{

    private static final long serialVersionUID = -6762009162940956898L;

    private Integer id;
    private String className;
    private String methodName;
    private Timestamp createTime;
    private String loglevel;
    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getLoglevel() {
        return loglevel;
    }

    public void setLoglevel(String loglevel) {
        this.loglevel = loglevel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SystemLogDo{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", createTime=" + createTime +
                ", loglevel='" + loglevel + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
