package com.cn.dao.classinfo;

import com.cn.beans.classinfo.ClassInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassInfoDao {
    ClassInfo getClassInfoById(@Param("classId") int classId, @Param("isEnable") int isEnable);

    void insertClassInfo(ClassInfo classInfo);

    int updateClassInfo(ClassInfo classInfo);

    int updateClassInfoEnable(@Param("classId") int classId, @Param("isEnable") int isEnable);

    List<ClassInfo> getClassInfoList(@Param("className") String className, @Param("isEnable") int isEnable);

    int getClassInfoCountByName(@Param("className") String className, @Param("isEnable") int isEnable);
}
