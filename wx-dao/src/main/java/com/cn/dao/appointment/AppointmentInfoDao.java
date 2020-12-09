package com.cn.dao.appointment;

import com.cn.beans.appointment.AppointmentInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppointmentInfoDao {
    List<AppointmentInfo> getAppointmentList(String startDate, String endDate);

    AppointmentInfo getAppointmentInfoById(String appointmentId);

    AppointmentInfo getAppointmentByClassId(@Param("classId") String classId, @Param("nowTime") String nowTime);

    AppointmentInfo getAppointmentByTeacherId(@Param("teacherId") int teacherId, @Param("nowTime") String nowTime);
}
