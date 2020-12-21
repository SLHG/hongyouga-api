package com.cn.beans.classpackage;

/**
 * 课程套餐分类
 */
public class ClassPackageType {
    //主键
    private int id;
    //套餐名称
    private String packageName;
    //可用时长,单位:天
    private String enableTime;
    //可用次数
    private int enableNum;
    //可用课程类型.例如:1-大课,2-私教
    private String classType;
    //套餐状态
    private String isEnable;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getEnableTime() {
        return enableTime;
    }

    public void setEnableTime(String enableTime) {
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

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }

    @Override
    public String toString() {
        return "ClassPackageType{" +
                "id=" + id +
                ", packageName='" + packageName + '\'' +
                ", enableTime='" + enableTime + '\'' +
                ", enableNum=" + enableNum +
                ", classType='" + classType + '\'' +
                ", isEnable='" + isEnable + '\'' +
                '}';
    }
}
