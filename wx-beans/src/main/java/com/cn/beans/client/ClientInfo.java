package com.cn.beans.client;

public class ClientInfo {
    //微信id
    private String openId;
    //手机号
    private String mobile;
    //客户姓名
    private String name;
    //客户性别
    private String sex;
    //信息创建时间
    private String createTime;
    //客户类型
    private String clientType;
    //客户课程结束时间
    private String classEndTime;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getClassEndTime() {
        return classEndTime;
    }

    public void setClassEndTime(String classEndTime) {
        this.classEndTime = classEndTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClientInfo{" +
                "openId='" + openId + '\'' +
                ", mobile='" + mobile + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", createTime='" + createTime + '\'' +
                ", clientType='" + clientType + '\'' +
                ", classEndTime='" + classEndTime + '\'' +
                '}';
    }
}
