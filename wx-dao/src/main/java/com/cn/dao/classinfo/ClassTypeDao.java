package com.cn.dao.classinfo;

import com.cn.beans.classinfo.ClassType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassTypeDao {

    void insertClassType(ClassType classInfo);

    int updateClassType(ClassType classInfo);

    int deleteClassType(@Param("typeId") int classTypeId);

    List<ClassType> getClassTypeList(@Param("classTypeName") String classTypeName);

    int getClassTypeCountByName(ClassType classInfo);

    List<ClassType> getAllClassTypeList();
}
