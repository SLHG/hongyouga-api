package com.cn.service.classinfo;

import com.cn.beans.classinfo.ClassInfo;
import com.cn.beans.common.ResultBean;
import com.github.pagehelper.PageInfo;

public interface ClassInfoService {
    ClassInfo getClassInfoById(int classId, int isEnable);

    void insertClassInfo(ClassInfo classInfo);

    ResultBean updateClassInfo(ClassInfo classInfo);

    ResultBean deleteClassInfo(int classId);

    PageInfo<ClassInfo> getClassInfoList(int start, int limit, String className);

    int getClassInfoCountByName(String className);
}
