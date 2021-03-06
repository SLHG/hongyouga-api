package com.cn.beans.client;

public class ClientInfo {
    //微信id
    private String openId;
    //手机号
    private String mobile;
    //客户姓名
    private String clientName;
    //客户性别
    private String sex;
    //信息创建时间
    private String createTime;

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

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public String toString() {
        return "ClientInfo{" +
                "openId='" + openId + '\'' +
                ", mobile='" + mobile + '\'' +
                ", clientName='" + clientName + '\'' +
                ", sex='" + sex + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
