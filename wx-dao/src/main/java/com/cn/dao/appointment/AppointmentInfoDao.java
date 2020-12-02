package com.cn.dao.appointment;

import com.cn.beans.appointment.AppointmentInfo;

import java.util.List;

public interface AppointmentInfoDao {
    List<AppointmentInfo> getAppointmentList(String startDate, String endDate);

    AppointmentInfo getAppointmentInfoById(String appointmentId);
}
