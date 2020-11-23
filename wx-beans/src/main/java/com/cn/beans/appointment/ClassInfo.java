package com.cn.beans.appointment;

/**
 * 课程信息
 */
public class ClassInfo {

    //课程id
    private String classId;
    //课程名称
    private String className;
    //课程类型
    private String classType;
    //课程简介
    private String classIntroduction;

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getClassIntroduction() {
        return classIntroduction;
    }

    public void setClassIntroduction(String classIntroduction) {
        this.classIntroduction = classIntroduction;
    }

    @Override
    public String toString() {
        return "ClassInfo{" +
                "classId='" + classId + '\'' +
                ", className='" + className + '\'' +
                ", classType='" + classType + '\'' +
                ", classIntroduction='" + classIntroduction + '\'' +
                '}';
    }
}
