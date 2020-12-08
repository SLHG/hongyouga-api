package com.cn.service.appointment;

import com.cn.beans.appointment.MakeAppointmentLog;
import com.github.pagehelper.PageInfo;

public interface MakeAppointmentLogService {
    void insertMakeAppointmentLog();

    PageInfo<MakeAppointmentLog> getMakeAppointmentLogList(int start, int limit, String startDate, String endDate, String mobile);
}
