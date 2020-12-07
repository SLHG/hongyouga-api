package com.cn.config;

import com.cn.service.appointment.MakeAppointmentLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    @Autowired
    MakeAppointmentLogService makeAppointmentLogService;

    @Scheduled(fixedRate = 5000)
    public void insertMakeAppointmentLogTask() {
        makeAppointmentLogService.insertMakeAppointmentLog();
    }

}
