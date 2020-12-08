package com.cn.dao.appointment;

import com.cn.beans.appointment.MakeAppointmentLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MakeAppointmentLogDao {
    void insertMakeAppointmentLogList(List<MakeAppointmentLog> logs);

    List<MakeAppointmentLog> getMakeAppointmentLogList(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("mobile") String mobile);
}
