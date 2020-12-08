package com.cn.dao.classinfo;

import com.cn.beans.classinfo.ClassInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassInfoDao {
    ClassInfo getClassInfoById(@Param("classId") int classId, @Param("isEnable") String isEnable);

    void insertClassInfo(ClassInfo classInfo);

    int updateClassInfo(ClassInfo classInfo);

    int deleteClassInfo(@Param("classId") String classId, @Param("isEnable") String isEnable);

    List<ClassInfo> getClassInfoList(@Param("className") String className, @Param("isEnable") String isEnable);
}
