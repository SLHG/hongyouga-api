package com.cn.service.impl.appointment;

import com.cn.beans.appointment.AppointmentInfo;
import com.cn.beans.common.Constant;
import com.cn.dao.appointment.AppointmentInfoDao;
import com.cn.service.appointment.AppointmentInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AppointmentInfoServiceImpl implements AppointmentInfoService {

    private static final Logger LOGGER = Logger.getLogger(AppointmentInfoServiceImpl.class);

    @Autowired
    AppointmentInfoDao appointmentInfoDao;

    @Override
    public Map<Integer, List<AppointmentInfo>> getAppointmentList(String startDate, int dayNum) {
        SimpleDateFormat format = new SimpleDateFormat(Constant.DATE_FORMAT1);
        Date date;
        try {
            date = format.parse(startDate);
        } catch (ParseException e) {
            LOGGER.error("getAppointmentList=>格式化日期错误", e);
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Map<Integer, List<AppointmentInfo>> appointmentInfoMap = new HashMap<>();
        for (int i = 0; i <= dayNum; i++) {
            String start = format.format(calendar.getTime());
            //时间递增一天,下次循环获取明天的课程列表
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            String end = format.format(calendar.getTime());
            //获取当天的课程列表
            List<AppointmentInfo> list = appointmentInfoDao.getAppointmentList(start, end);
            if (list != null) {
                appointmentInfoMap.put(i, list);
            }
        }
        return appointmentInfoMap;
    }
}
