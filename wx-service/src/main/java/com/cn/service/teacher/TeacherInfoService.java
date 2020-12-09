package com.cn.service.teacher;

import com.cn.beans.common.ResultBean;
import com.cn.beans.teacher.TeacherInfo;
import com.github.pagehelper.PageInfo;

public interface TeacherInfoService {

    TeacherInfo getTeacherInfoById(int teacherId);

    void insertTeacherInfo(TeacherInfo teacherInfo);

    int updateTeacherInfo(TeacherInfo teacherInfo);

    ResultBean deleteTeacherInfo(int teacherId);

    PageInfo<TeacherInfo> getTeacherInfoList(int start, int limit, String teacherName);
}
