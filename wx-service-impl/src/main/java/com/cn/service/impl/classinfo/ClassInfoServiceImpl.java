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
    public ResultBean insertClassInfo(ClassInfo classInfo) {
        int count = classInfoDao.getClassInfoCountByName(classInfo.getClassName(), Status.IS_ENABLE.getStatus());
        if (count == 1) {
            return new ResultBean(ResultBean.FAIL_CODE, "课程名称重复,新增失败");
        }
        classInfoDao.insertClassInfo(classInfo);
        return new ResultBean();
    }

    @Override
    public ResultBean updateClassInfo(ClassInfo classInfo) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constant.DATE_FORMAT2);
        String nowTime = simpleDateFormat.format(new Date());
        AppointmentInfo appointmentInfo = appointmentInfoDao.getAppointmentByClassId(classInfo.getClassId(), nowTime);
        if (appointmentInfo != null) {
            return new ResultBean(ResultBean.FAIL_CODE, "课程在使用中,无法编辑.");
        }
        int countByName = classInfoDao.getClassInfoCountByName(classInfo.getClassName(), Status.IS_ENABLE.getStatus());
        if (countByName == 1) {
            return new ResultBean(ResultBean.FAIL_CODE, "课程名称重复,更新失败");
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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constant.DATE_FORMAT2);
        String nowTime = simpleDateFormat.format(new Date());
        AppointmentInfo appointmentInfo = appointmentInfoDao.getAppointmentByClassId(classId, nowTime);
        if (appointmentInfo != null) {
            return new ResultBean(ResultBean.FAIL_CODE, "课程在使用中,无法删除");
        }
        int deleteCount = classInfoDao.updateClassInfoEnable(classId, Status.NOT_ENABLE.getStatus());
        if (deleteCount == 1) {
            return new ResultBean();
        }
        return new ResultBean(ResultBean.FAIL_CODE, "删除失败");
    }

    @Override
    public PageInfo<ClassInfo> getClassInfoList(int start, int limit, String className) {
        PageHelper.startPage(start, limit);
        List<ClassInfo> list = classInfoDao.getClassInfoList(className, Status.IS_ENABLE.getStatus());
        return new PageInfo<>(list);
    }

}
