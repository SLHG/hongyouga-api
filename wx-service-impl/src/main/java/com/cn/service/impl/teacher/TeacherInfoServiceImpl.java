package com.cn.service.impl.teacher;

import com.cn.beans.appointment.AppointmentInfo;
import com.cn.beans.common.Constant;
import com.cn.beans.common.ResultBean;
import com.cn.beans.teacher.TeacherInfo;
import com.cn.dao.appointment.AppointmentInfoDao;
import com.cn.dao.teacher.TeacherInfoDao;
import com.cn.service.teacher.TeacherInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TeacherInfoServiceImpl implements TeacherInfoService {

    //信息状态1-可用,0-不可用
    private static final String isNotEnable = "0";
    private static final String isEnable = "1";

    @Autowired
    TeacherInfoDao teacherInfoDao;

    @Autowired
    AppointmentInfoDao appointmentInfoDao;

    @Override
    public TeacherInfo getTeacherInfoById(int teacherId) {
        return teacherInfoDao.getTeacherInfoById(teacherId, isEnable);
    }

    @Override
    public void insertTeacherInfo(TeacherInfo teacherInfo) {
        teacherInfoDao.insertTeacherInfo(teacherInfo);
    }

    @Override
    public int updateTeacherInfo(TeacherInfo teacherInfo) {
        teacherInfo.setIsEnable(isEnable);
        return teacherInfoDao.updateTeacherInfo(teacherInfo);
    }

    @Override
    public ResultBean deleteTeacherInfo(int teacherId) {
        ResultBean resultBean = new ResultBean();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constant.DATE_FORMAT2);
        String nowTime = simpleDateFormat.format(new Date());
        AppointmentInfo appointmentInfo = appointmentInfoDao.getAppointmentByTeacherId(teacherId, nowTime);
        if (appointmentInfo != null) {
            resultBean.setRtnMsg("当前老师存在已排课程,无法删除");
            resultBean.setRtnCode(ResultBean.FAIL_CODE);
            return resultBean;
        }
        int delCount = teacherInfoDao.deleteTeacherInfo(teacherId, isNotEnable);
        if (delCount == 1) {
            return resultBean;
        }
        resultBean.setRtnCode(ResultBean.FAIL_CODE);
        resultBean.setRtnMsg("删除失败");
        return resultBean;
    }

    @Override
    public PageInfo<TeacherInfo> getTeacherInfoList(int start, int limit, String teacherName) {
        PageHelper.startPage(start, limit);
        List<TeacherInfo> list = teacherInfoDao.getTeacherInfoList(teacherName, isEnable);
        return new PageInfo<>(list);
    }
}
