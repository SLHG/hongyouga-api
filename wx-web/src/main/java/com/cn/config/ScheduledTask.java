package com.cn.config;

import com.cn.service.appointment.MakeAppointmentLogService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    private static final Logger LOGGER = Logger.getLogger(ScheduledTask.class);

    @Autowired
    MakeAppointmentLogService makeAppointmentLogService;

    @Scheduled(fixedRate = 5000)
    public void insertMakeAppointmentLogTask() {
        LOGGER.info("insertAppointmentLogTask=>开始执行入库日志");
        makeAppointmentLogService.insertMakeAppointmentLog();
        LOGGER.info("insertAppointmentLogTask=>执行结束");
    }

}
