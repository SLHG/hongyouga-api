package com.cn.service.impl.teacher;

import com.cn.beans.appointment.AppointmentInfo;
import com.cn.beans.common.Constant;
import com.cn.beans.common.ResultBean;
import com.cn.beans.common.Status;
import com.cn.beans.teacher.TeacherInfo;
import com.cn.dao.appointment.AppointmentInfoDao;
import com.cn.dao.teacher.TeacherInfoDao;
import com.cn.service.teacher.TeacherInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TeacherInfoServiceImpl implements TeacherInfoService {

    final TeacherInfoDao teacherInfoDao;

    final AppointmentInfoDao appointmentInfoDao;

    public TeacherInfoServiceImpl(TeacherInfoDao teacherInfoDao, AppointmentInfoDao appointmentInfoDao) {
        this.teacherInfoDao = teacherInfoDao;
        this.appointmentInfoDao = appointmentInfoDao;
    }

    @Override
    public TeacherInfo getTeacherInfoById(int teacherId) {
        return teacherInfoDao.getTeacherInfoById(teacherId, Status.IS_ENABLE.getStatus());
    }

    @Override
    public void insertTeacherInfo(TeacherInfo teacherInfo) {
        teacherInfoDao.insertTeacherInfo(teacherInfo);
    }

    @Override
    public int updateTeacherInfo(TeacherInfo teacherInfo) {
        teacherInfo.setIsEnable(Status.IS_ENABLE.getStatus());
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
        int delCount = teacherInfoDao.deleteTeacherInfo(teacherId, Status.NOT_ENABLE.getStatus());
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
        List<TeacherInfo> list = teacherInfoDao.getTeacherInfoList(teacherName, Status.IS_ENABLE.getStatus());
        return new PageInfo<>(list);
    }
}
