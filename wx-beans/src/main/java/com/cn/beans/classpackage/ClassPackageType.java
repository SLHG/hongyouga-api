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
    private int classType;
    //课程类型名称
    private String classTypeName;
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

    public int getClassType() {
        return classType;
    }

    public void setClassType(int classType) {
        this.classType = classType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getClassTypeName() {
        return classTypeName;
    }

    public void setClassTypeName(String classTypeName) {
        this.classTypeName = classTypeName;
    }

    @Override
    public String toString() {
        return "ClassPackageType{" +
                "packageId=" + packageId +
                ", packageName='" + packageName + '\'' +
                ", enableTime=" + enableTime +
                ", enableNum=" + enableNum +
                ", classType='" + classType + '\'' +
                ", classTypeName='" + classTypeName + '\'' +
                ", status=" + status +
                '}';
    }
}
