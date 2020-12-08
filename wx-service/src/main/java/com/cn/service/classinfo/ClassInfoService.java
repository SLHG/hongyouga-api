package com.cn.service.classinfo;

import com.cn.beans.classinfo.ClassInfo;
import com.cn.beans.common.ResultBean;
import com.github.pagehelper.PageInfo;

public interface ClassInfoService {
    ClassInfo getClassInfoById(int classId);

    void insertClassInfo(ClassInfo classInfo);

    int updateClassInfo(ClassInfo classInfo);

    ResultBean deleteClassInfo(String classId);

    PageInfo<ClassInfo> getClassInfoList(int start, int limit, String className);
}
