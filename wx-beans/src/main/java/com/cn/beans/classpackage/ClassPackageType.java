package com.cn.beans.classpackage;

/**
 * 课程套餐分类
 */
public class ClassPackageType {
    //主键
    private int packageId;
    //套餐名称
    private String packageName;
    //可用时长,单位:天
    private int enableTime;
    //可用次数
    private int enableNum;
    //可用课程类型.例如:1-大课,2-私教
    private String classType;
    //套餐是否可用 0-删除,1-可用
    private int isEnable;
    //套餐状态 0-暂停,1-启用
    private int status;

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getEnableTime() {
        return enableTime;
    }

    public void setEnableTime(int enableTime) {
        this.enableTime = enableTime;
    }

    public int getEnableNum() {
        return enableNum;
    }

    public void setEnableNum(int enableNum) {
        this.enableNum = enableNum;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public int getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(int isEnable) {
        this.isEnable = isEnable;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ClassPackageType{" +
                "packageId=" + packageId +
                ", packageName='" + packageName + '\'' +
                ", enableTime=" + enableTime +
                ", enableNum=" + enableNum +
                ", classType='" + classType + '\'' +
                ", isEnable=" + isEnable +
                ", status=" + status +
                '}';
    }
}
