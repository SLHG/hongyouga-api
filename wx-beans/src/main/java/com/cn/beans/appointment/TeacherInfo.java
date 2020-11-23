package com.cn.beans.appointment;

public class TeacherInfo {

    //老师id
    private String teacherId;
    //老师姓名
    private String teacherName;
    //老师课程特色
    private String teacherType;
    //老师简介
    private String teacherIntroduction;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherType() {
        return teacherType;
    }

    public void setTeacherType(String teacherType) {
        this.teacherType = teacherType;
    }

    public String getTeacherIntroduction() {
        return teacherIntroduction;
    }

    public void setTeacherIntroduction(String teacherIntroduction) {
        this.teacherIntroduction = teacherIntroduction;
    }

    @Override
    public String toString() {
        return "TeacherInfo{" +
                "teacherId='" + teacherId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherType='" + teacherType + '\'' +
                ", teacherIntroduction='" + teacherIntroduction + '\'' +
                '}';
    }
}
