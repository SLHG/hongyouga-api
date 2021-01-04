package com.cn.dao.classpackage;

import com.cn.beans.classpackage.ClassPackageType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassPackageTypeDao {
    void insertClassPackageType(ClassPackageType classPackageType);

    int updateClassPackageType(ClassPackageType classPackageType);

    List<ClassPackageType> getClassPackageTypeList(@Param("packageName") String packageName, @Param("isEnable") int isEnable);

    int deleteClassPackageType(@Param("packageId") int packageId, @Param("isEnable") int isEnable);
}
