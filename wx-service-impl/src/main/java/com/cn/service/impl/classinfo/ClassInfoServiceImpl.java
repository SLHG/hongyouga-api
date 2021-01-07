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
    public ClassInfo getClassInfoById(int classId, int isEnable) {
        return classInfoDao.getClassInfoById(classId, isEnable);
    }

    @Override
    public void insertClassInfo(ClassInfo classInfo) {
        classInfoDao.insertClassInfo(classInfo);
    }

    @Override
    public ResultBean updateClassInfo(ClassInfo classInfo) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constant.DATE_FORMAT2);
        String nowTime = simpleDateFormat.format(new Date());
        AppointmentInfo appointmentInfo = appointmentInfoDao.getAppointmentByClassId(classInfo.getClassId(), nowTime);
        if (appointmentInfo != null) {
            return new ResultBean(ResultBean.FAIL_CODE, "课程在使用中,无法编辑.");
        }
        classInfo.setIsEnable(Status.IS_ENABLE.getStatus());
        int updateCount = classInfoDao.updateClassInfo(classInfo);
        if (updateCount == 1) {
            return new ResultBean();
        }
        return new ResultBean(ResultBean.FAIL_CODE, "更新失败");
    }

    @Override
    public ResultBean deleteClassInfo(int classId) {
        ResultBean resultBean = new ResultBean();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constant.DATE_FORMAT2);
        String nowTime = simpleDateFormat.format(new Date());
        AppointmentInfo appointmentInfo = appointmentInfoDao.getAppointmentByClassId(classId, nowTime);
        if (appointmentInfo != null) {
            resultBean.setRtnMsg("此课程还在使用中,无法删除");
            resultBean.setRtnCode(ResultBean.FAIL_CODE);
            return resultBean;
        }
        int deleteCount = classInfoDao.updateClassInfoEnable(classId, Status.NOT_ENABLE.getStatus());
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

    @Override
    public int getClassInfoCountByName(String className) {
        return classInfoDao.getClassInfoCountByName(className, Status.IS_ENABLE.getStatus());
    }
}
