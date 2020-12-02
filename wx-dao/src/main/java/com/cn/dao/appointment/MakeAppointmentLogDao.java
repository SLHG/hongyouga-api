package com.cn.dao.appointment;

import com.cn.beans.appointment.MakeAppointmentLog;

import java.util.List;

public interface MakeAppointmentLogDao {
    void insertMakeAppointmentLogList(List<MakeAppointmentLog> logs);
}
