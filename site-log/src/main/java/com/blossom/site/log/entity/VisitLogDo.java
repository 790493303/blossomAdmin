package com.blossom.site.log.entity;

import java.io.Serializable;

/**
 * @author Blossom
 * @Description 访问日志实体类
 * @time 2017/3/24 9:47
 */
public class VisitLogDo implements Serializable{

    private static final long serialVersionUID = 5296220336708791922L;

    private Integer id;
    private String url;
    private String httpMethod;
    private String description;
    private String method;
    private String requestIp;
    private String params;
    private String createBy;
    private String createDate;
    private String broswer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getBroswer() {
        return broswer;
    }

    public void setBroswer(String broswer) {
        this.broswer = broswer;
    }

    @Override
    public String toString() {
        return "VisitLogDo{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", httpMethod='" + httpMethod + '\'' +
                ", description='" + description + '\'' +
                ", method='" + method + '\'' +
                ", requestIp='" + requestIp + '\'' +
                ", params='" + params + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createDate='" + createDate + '\'' +
                ", broswer='" + broswer + '\'' +
                '}';
    }
}
