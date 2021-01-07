package com.cn.beans.classinfo;

/**
 * 课程信息
 */
public class ClassInfo {

    //课程id
    private int classId;
    //课程名称
    private String className;
    //课程特色
    private String classFeatures;
    //课程简介
    private String classIntroduction;
    //创建时间
    private String createTime;
    //是否可用
    private int isEnable;
    //课程类型
    private int classType;

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getClassType() {
        return classType;
    }

    public void setClassType(int classType) {
        this.classType = classType;
    }

    public String getClassIntroduction() {
        return classIntroduction;
    }

    public void setClassIntroduction(String classIntroduction) {
        this.classIntroduction = classIntroduction;
    }

    public int getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(int isEnable) {
        this.isEnable = isEnable;
    }

    public String getClassFeatures() {
        return classFeatures;
    }

    public void setClassFeatures(String classFeatures) {
        this.classFeatures = classFeatures;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ClassInfo{" +
                "classId='" + classId + '\'' +
                ", className='" + className + '\'' +
                ", classFeatures='" + classFeatures + '\'' +
                ", classIntroduction='" + classIntroduction + '\'' +
                ", createTime='" + createTime + '\'' +
                ", isEnable='" + isEnable + '\'' +
                ", classType='" + classType + '\'' +
                '}';
    }
}
