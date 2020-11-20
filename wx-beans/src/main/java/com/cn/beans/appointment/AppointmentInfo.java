package com.cn.beans.appointment;

/**
 * 约课信息
 */
public class AppointmentInfo {

    //主键id
    private String appointmentId;
    //课程名称
    private String className;
    //课程id
    private String classId;
    //结束时间
    private String startTime;
    //开始时间
    private String endTime;
    //老师id
    private String teacherId;
    //老师姓名
    private String teacherName;
    //备注
    private String remarks;
    //限制人数
    private String limitNum;

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getLimitNum() {
        return limitNum;
    }

    public void setLimitNum(String limitNum) {
        this.limitNum = limitNum;
    }

    @Override
    public String toString() {
        return "AppointmentInfo{" +
                "appointmentId='" + appointmentId + '\'' +
                ", className='" + className + '\'' +
                ", classId='" + classId + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", remarks='" + remarks + '\'' +
                ", limitNum='" + limitNum + '\'' +
                '}';
    }
}
