package com.cn.beans.appointment;

/**
 * 约课日志
 */
public class MakeAppointmentLog {

    private String id;
    //课程名称
    private String className;
    //课程信息表主键
    private String classId;
    //结束时间
    private String startTime;
    //开始时间
    private String endTime;
    //老师姓名
    private String teacherName;
    //老师信息表主键
    private String teacherId;
    //微信id
    private String openId;
    //手机号
    private String mobile;
    //客户姓名
    private String clientName;
    //客户性别
    private String sex;
    //客户类型
    private String clientType;
    //约课状态
    private int appointmentStatus;
    //约课信息表主键
    private String appointmentId;
    //创建时间
    private String createTime;

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

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    @Override
    public String toString() {
        return "MakeAppointmentLog{" +
                "id='" + id + '\'' +
                ", className='" + className + '\'' +
                ", classId='" + classId + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", openId='" + openId + '\'' +
                ", mobile='" + mobile + '\'' +
                ", clientName='" + clientName + '\'' +
                ", sex='" + sex + '\'' +
                ", clientType='" + clientType + '\'' +
                ", appointmentStatus=" + appointmentStatus +
                ", appointmentId=" + appointmentId +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
