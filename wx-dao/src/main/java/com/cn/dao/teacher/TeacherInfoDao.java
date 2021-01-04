package com.cn.dao.teacher;

import com.cn.beans.teacher.TeacherInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherInfoDao {
    TeacherInfo getTeacherInfoById(@Param("teacherId") int teacherId, @Param("isEnable") int isEnable);

    void insertTeacherInfo(TeacherInfo teacherInfo);

    int updateTeacherInfo(TeacherInfo teacherInfo);

    int deleteTeacherInfo(@Param("teacherId") int teacherId, @Param("isEnable") int isEnable);

    List<TeacherInfo> getTeacherInfoList(@Param("teacherName") String teacherName, @Param("isEnable") int isEnable);
}
