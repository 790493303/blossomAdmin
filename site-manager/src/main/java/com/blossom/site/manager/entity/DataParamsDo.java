package com.blossom.site.manager.entity;

import java.io.Serializable;

/**
 * @author Blossom
 * @Description 数据库连接参数实体类
 * @time 2017/3/30 22:46
 */
public class DataParamsDo implements Serializable{


    private static final long serialVersionUID = 7299338607842563677L;

    private Integer id;
    private Integer dataType;
    private String dataName;
    private String dataAddress;
    private String port;
    private String userName;
    private String password;
    private String url;
    private String driver;
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public String getDataAddress() {
        return dataAddress;
    }

    public void setDataAddress(String dataAddress) {
        this.dataAddress = dataAddress;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DataParamsDo{" +
                "id=" + id +
                ", dataType=" + dataType +
                ", dataName='" + dataName + '\'' +
                ", dataAddress='" + dataAddress + '\'' +
                ", port='" + port + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", url='" + url + '\'' +
                ", driver='" + driver + '\'' +
                ", status=" + status +
                '}';
    }
}
