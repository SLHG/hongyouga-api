package com.cn.beans.appointment;

//约课日志记录状态
public enum AppointmentStatus {
    //成功
    SUCCESS(1),
    //客户非会员
    NON_MEMBER(2),
    //无名额
    NO_QUOTA(3);

    private final int status;

    AppointmentStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
