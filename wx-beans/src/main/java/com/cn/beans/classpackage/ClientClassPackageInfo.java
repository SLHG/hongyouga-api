package com.cn.beans.classpackage;

/**
 * 客户订购课程套餐信息
 */
public class ClientClassPackageInfo {

    //用户id
    private String openId;
    //用户手机号
    private String mobile;
    //套餐id
    private int packageId;
    //开始时间
    private String beginTime;
    //剩余可用次数
    private int enableNum;
    //结束时间
    private String endTime;
    //可用课程类型
    private String classType;
    //创建时间
    private String createTime;
    //套餐状态
    private String isEnable;

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

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public int getEnableNum() {
        return enableNum;
    }

    public void setEnableNum(int enableNum) {
        this.enableNum = enableNum;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }

    @Override
    public String toString() {
        return "ClientClassPackageInfo{" +
                "openId='" + openId + '\'' +
                ", mobile='" + mobile + '\'' +
                ", packageId=" + packageId +
                ", beginTime='" + beginTime + '\'' +
                ", enableNum=" + enableNum +
                ", endTime='" + endTime + '\'' +
                ", classType='" + classType + '\'' +
                ", createTime='" + createTime + '\'' +
                ", isEnable='" + isEnable + '\'' +
                '}';
    }
}
