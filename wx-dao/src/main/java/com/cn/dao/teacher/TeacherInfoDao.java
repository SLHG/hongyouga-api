package com.cn.dao.teacher;

import com.cn.beans.teacher.TeacherInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherInfoDao {
    TeacherInfo getTeacherInfoById(@Param("teacherId") int teacherId, @Param("isEnable") String isEnable);

    void insertTeacherInfo(TeacherInfo teacherInfo);

    int updateTeacherInfo(TeacherInfo teacherInfo);

    int deleteTeacherInfo(@Param("teacherId") int teacherId, @Param("isEnable") String isEnable);

    List<TeacherInfo> getTeacherInfoList(@Param("teacherName") String teacherName, @Param("isEnable") String isEnable);
}
