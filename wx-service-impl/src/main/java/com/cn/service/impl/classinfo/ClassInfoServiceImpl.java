package com.cn.service.impl.classinfo;

import com.cn.beans.appointment.AppointmentInfo;
import com.cn.beans.classinfo.ClassInfo;
import com.cn.beans.common.Constant;
import com.cn.beans.common.ResultBean;
import com.cn.beans.common.Status;
import com.cn.dao.appointment.AppointmentInfoDao;
import com.cn.dao.classinfo.ClassInfoDao;
import com.cn.service.classinfo.ClassInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ClassInfoServiceImpl implements ClassInfoService {

    final ClassInfoDao classInfoDao;
    final AppointmentInfoDao appointmentInfoDao;

    public ClassInfoServiceImpl(ClassInfoDao classInfoDao, AppointmentInfoDao appointmentInfoDao) {
        this.classInfoDao = classInfoDao;
        this.appointmentInfoDao = appointmentInfoDao;
    }

    @Override
    public ClassInfo getClassInfoById(int classId) {
        return classInfoDao.getClassInfoById(classId, Status.IS_ENABLE.getStatus());
    }

    @Override
    public void insertClassInfo(ClassInfo classInfo) {
        classInfoDao.insertClassInfo(classInfo);
    }

    @Override
    public int updateClassInfo(ClassInfo classInfo) {
        classInfo.setIsEnable(Status.IS_ENABLE.getStatus());
        return classInfoDao.updateClassInfo(classInfo);
    }

    @Override
    public ResultBean deleteClassInfo(String classId) {
        ResultBean resultBean = new ResultBean();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constant.DATE_FORMAT2);
        String nowTime = simpleDateFormat.format(new Date());
        AppointmentInfo appointmentInfo = appointmentInfoDao.getAppointmentByClassId(classId, nowTime);
        if (appointmentInfo != null) {
            resultBean.setRtnMsg("此课程还在使用中,无法删除");
            resultBean.setRtnCode(ResultBean.FAIL_CODE);
            return resultBean;
        }
        int deleteCount = classInfoDao.deleteClassInfo(classId, Status.NOT_ENABLE.getStatus());
        if (deleteCount == 1) {
            return resultBean;
        }
        resultBean.setRtnMsg("删除失败");
        resultBean.setRtnCode(ResultBean.FAIL_CODE);
        return resultBean;
    }

    @Override
    public PageInfo<ClassInfo> getClassInfoList(int start, int limit, String className) {
        PageHelper.startPage(start, limit);
        List<ClassInfo> list = classInfoDao.getClassInfoList(className, Status.IS_ENABLE.getStatus());
        return new PageInfo<>(list);
    }
}
