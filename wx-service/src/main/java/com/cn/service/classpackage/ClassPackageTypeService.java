package com.cn.service.classpackage;

import com.cn.beans.classpackage.ClassPackageType;
import com.cn.beans.common.ResultBean;
import com.github.pagehelper.PageInfo;

public interface ClassPackageTypeService {
    void insertClassPackageType(ClassPackageType classPackageType);

    ResultBean updateClassPackageType(ClassPackageType classPackageType);

    ResultBean deleteClassPackageType(int id);

    PageInfo<ClassPackageType> getClassPackageTypeList(int start, int limit, String packageName);
}
