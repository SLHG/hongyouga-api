package com.cn.service.impl.classinfo;

import com.cn.beans.appointment.AppointmentInfo;
import com.cn.beans.classinfo.ClassInfo;
import com.cn.beans.common.ResultBean;
import com.cn.dao.appointment.AppointmentInfoDao;
import com.cn.dao.classinfo.ClassInfoDao;
import com.cn.service.classinfo.ClassInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassInfoServiceImpl implements ClassInfoService {
    //课程信息状态1-可用,0-不可用
    private static final String isNotEnable = "0";
    private static final String isEnable = "1";

    @Autowired
    ClassInfoDao classInfoDao;
    @Autowired
    AppointmentInfoDao appointmentInfoDao;

    @Override
    public ClassInfo getClassInfoById(int classId) {
        return classInfoDao.getClassInfoById(classId, isEnable);
    }

    @Override
    public void insertClassInfo(ClassInfo classInfo) {
        classInfoDao.insertClassInfo(classInfo);
    }

    @Override
    public int updateClassInfo(ClassInfo classInfo) {
        classInfo.setIsEnable(isEnable);
        return classInfoDao.updateClassInfo(classInfo);
    }

    @Override
    public ResultBean deleteClassInfo(String classId) {
        ResultBean resultBean = new ResultBean();
        AppointmentInfo appointmentInfo = appointmentInfoDao.getAppointmentByClassId(classId);
        if (appointmentInfo != null) {
            resultBean.setRtnMsg("此课程还在使用中,无法删除");
            resultBean.setRtnCode(ResultBean.FAIL_CODE);
            return resultBean;
        }
        int deleteCount = classInfoDao.deleteClassInfo(classId, isNotEnable);
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
        List<ClassInfo> list = classInfoDao.getClassInfoList(className, isEnable);
        return new PageInfo<>(list);
    }
}
