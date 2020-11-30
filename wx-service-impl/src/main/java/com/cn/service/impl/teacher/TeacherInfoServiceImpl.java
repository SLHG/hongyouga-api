package com.cn.service.impl.teacher;

import com.cn.beans.teacher.TeacherInfo;
import com.cn.dao.teacher.TeacherInfoDao;
import com.cn.service.teacher.TeacherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherInfoServiceImpl implements TeacherInfoService {

    @Autowired
    TeacherInfoDao teacherInfoDao;

    @Override
    public TeacherInfo getTeacherInfoById(int teacherId) {
        return teacherInfoDao.getTeacherInfoById(teacherId);
    }
}
