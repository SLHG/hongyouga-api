package com.cn.service.appointment;

import com.cn.beans.appointment.AppointmentInfo;

import java.util.List;
import java.util.Map;

public interface AppointmentInfoService {
    Map<Integer, List<AppointmentInfo>> getAppointmentList(String startDate, int dayNum);
}
