package com.cn.beans.teacher;

public class TeacherInfo {

    //老师id
    private String teacherId;
    //老师姓名
    private String teacherName;
    //老师课程特色
    private String teacherType;
    //老师简介
    private String teacherIntroduction;
    //是否可用
    private String isEnable;
    //创建时间
    private String createTime;

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

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "TeacherInfo{" +
                "teacherId='" + teacherId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherType='" + teacherType + '\'' +
                ", teacherIntroduction='" + teacherIntroduction + '\'' +
                ", isEnable='" + isEnable + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
