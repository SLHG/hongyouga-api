package com.cn.beans.appointment;

/**
 * 约课日志
 */
public class MakeAppointmentLog {

    private String id;
    //课程名称
    private String className;
    //结束时间
    private String startTime;
    //开始时间
    private String endTime;
    //老师姓名
    private String teacherName;
    //微信id
    private String openId;
    //手机号
    private String mobile;
    //客户姓名
    private String name;
    //客户性别
    private String sex;
    //客户类型
    private String clientType;
    //约课状态
    private int appointmentStatus;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(int appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    @Override
    public String toString() {
        return "MakeAppointmentLog{" +
                "id='" + id + '\'' +
                ", className='" + className + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", openId='" + openId + '\'' +
                ", mobile='" + mobile + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", clientType='" + clientType + '\'' +
                ", appointmentStatus=" + appointmentStatus +
                '}';
    }
}
