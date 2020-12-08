package com.cn.service.impl.appointment;

import com.alibaba.fastjson.JSON;
import com.cn.beans.appointment.MakeAppointmentLog;
import com.cn.beans.common.Constant;
import com.cn.dao.appointment.MakeAppointmentLogDao;
import com.cn.service.appointment.MakeAppointmentLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MakeAppointmentLogServiceImpl implements MakeAppointmentLogService {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Autowired
    MakeAppointmentLogDao makeAppointmentLogDao;

    @Override
    public void insertMakeAppointmentLog() {
        List<MakeAppointmentLog> logs = new ArrayList<>();
        while (true) {
            String log = redisTemplate.opsForList().leftPop(Constant.APPOINTMENT_LOG);
            if (StringUtils.isBlank(log)) {
                break;
            }
            MakeAppointmentLog makeAppointmentLog = JSON.parseObject(log, MakeAppointmentLog.class);
            logs.add(makeAppointmentLog);
        }
        if (logs.isEmpty()) {
            return;
        }
        makeAppointmentLogDao.insertMakeAppointmentLogList(logs);
    }

    @Override
    public PageInfo<MakeAppointmentLog> getMakeAppointmentLogList(int start, int limit, String startDate, String endDate, String mobile) {
        PageHelper.startPage(start, limit);
        List<MakeAppointmentLog> makeAppointmentLogList = makeAppointmentLogDao.getMakeAppointmentLogList(startDate, endDate, mobile);
        return new PageInfo<>(makeAppointmentLogList);
    }
}
