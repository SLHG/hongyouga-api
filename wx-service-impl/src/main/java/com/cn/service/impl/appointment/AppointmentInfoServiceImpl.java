package com.cn.service.impl.appointment;

import com.alibaba.fastjson.JSON;
import com.cn.beans.appointment.AppointmentInfo;
import com.cn.beans.appointment.AppointmentStatus;
import com.cn.beans.appointment.MakeAppointmentLog;
import com.cn.beans.client.ClientInfo;
import com.cn.beans.common.Constant;
import com.cn.beans.common.ResultBean;
import com.cn.dao.appointment.AppointmentInfoDao;
import com.cn.service.appointment.AppointmentInfoService;
import com.cn.service.client.ClientInfoService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class AppointmentInfoServiceImpl implements AppointmentInfoService {

    private static final Logger LOGGER = Logger.getLogger(AppointmentInfoServiceImpl.class);
    //记录约课人数
    private static final String APPOINTMENT_NUM = "APPOINTMENT:NUM:";
    //记录客户已预约课程信息
    private static final String APPOINTMENT_INFO = "APPOINTMENT:INFO:";
    //课程已预约标识
    private static final String IS_APPOINTMENT = "1";
    private static final long APPOINTMENT_EXPIRE = 30 * 24 * 3600;

    @Autowired
    AppointmentInfoDao appointmentInfoDao;

    @Autowired
    ClientInfoService clientInfoService;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

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

    @Override
    public ResultBean makeAppointment(String openId, String appointmentId) {
        String isAppointment = redisTemplate.opsForValue().get(APPOINTMENT_INFO + openId + Constant.UNDER_LINE + appointmentId);
        ResultBean resultBean = new ResultBean();
        if (IS_APPOINTMENT.equals(isAppointment)) {
            resultBean.setRtnMsg("您已预约过此课程.");
            resultBean.setRtnCode(ResultBean.FAIL_CODE);
            return resultBean;
        }
        //获取用户信息
        ClientInfo clientInfo = clientInfoService.getClientInfoByOpenId(openId);
        if (clientInfo == null) {
            resultBean.setRtnMsg("客户信息不存在.");
            resultBean.setRtnCode(ResultBean.FAIL_CODE);
            return resultBean;
        }
        //获取课程信息
        AppointmentInfo appointmentInfo = appointmentInfoDao.getAppointmentInfoById(appointmentId);
        if (appointmentInfo == null) {
            resultBean.setRtnMsg("课程信息不存在.");
            resultBean.setRtnCode(ResultBean.FAIL_CODE);
            return resultBean;
        }
        String startTime = appointmentInfo.getStartTime();
        String limitNum = appointmentInfo.getLimitNum();
        if (StringUtils.isBlank(startTime) || StringUtils.isBlank(limitNum)) {
            resultBean.setRtnMsg("参数错误.");
            resultBean.setRtnCode(ResultBean.FAIL_CODE);
            return resultBean;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constant.DATE_FORMAT2);
        Date nowDate = new Date();
        try {
            Date startDate = simpleDateFormat.parse(startTime);
            if (nowDate.getTime() >= startDate.getTime()) {
                resultBean.setRtnMsg("此课程已过约课时间");
                resultBean.setRtnCode(ResultBean.FAIL_CODE);
                return resultBean;
            }
        } catch (ParseException e) {
            LOGGER.error("makeAppointment=>格式化课程日期失败", e);
        }
        int limit = Integer.parseInt(limitNum);
        Long appointmentNum = redisTemplate.opsForValue().increment(APPOINTMENT_NUM + appointmentId);
        redisTemplate.expire(APPOINTMENT_NUM + appointmentId, APPOINTMENT_EXPIRE, TimeUnit.SECONDS);
        if (appointmentNum == null || appointmentNum > limit) {
            redisTemplate.opsForValue().decrement(APPOINTMENT_NUM + appointmentId);
            resultBean.setRtnMsg("此课程已约满.");
            resultBean.setRtnCode(ResultBean.FAIL_CODE);
            insertAppointmentLog(clientInfo, appointmentInfo, AppointmentStatus.NO_QUOTA.getStatus());
            return resultBean;
        }
        redisTemplate.opsForValue().set(APPOINTMENT_INFO + openId + Constant.UNDER_LINE + appointmentId, IS_APPOINTMENT, APPOINTMENT_EXPIRE, TimeUnit.SECONDS);
        //记录约课日志
        insertAppointmentLog(clientInfo, appointmentInfo, AppointmentStatus.SUCCESS.getStatus());
        return resultBean;
    }

    /**
     * 记录客户约课信息日志
     *
     * @param clientInfo        客户信息
     * @param appointmentInfo   约课信息
     * @param appointmentStatus 预约情况
     */
    private void insertAppointmentLog(ClientInfo clientInfo, AppointmentInfo appointmentInfo, int appointmentStatus) {
        MakeAppointmentLog log = new MakeAppointmentLog();
        log.setClassName(appointmentInfo.getClassName());
        log.setTeacherName(appointmentInfo.getTeacherName());
        log.setStartTime(appointmentInfo.getStartTime());
        log.setEndTime(appointmentInfo.getEndTime());
        log.setSex(clientInfo.getSex());
        log.setOpenId(clientInfo.getOpenId());
        log.setClientName(clientInfo.getClientName());
        log.setMobile(clientInfo.getMobile());
        log.setTeacherId(appointmentInfo.getTeacherId());
        log.setClassId(appointmentInfo.getClassId());
        log.setAppointmentId(appointmentInfo.getAppointmentId());
        log.setAppointmentStatus(appointmentStatus);
        //记录约课日志
        redisTemplate.opsForList().rightPush(Constant.APPOINTMENT_LOG, JSON.toJSONString(log));
        redisTemplate.expire(Constant.APPOINTMENT_LOG, APPOINTMENT_EXPIRE, TimeUnit.SECONDS);
    }
}
