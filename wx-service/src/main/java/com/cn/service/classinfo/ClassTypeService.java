package com.cn.service.classinfo;

import com.cn.beans.classinfo.ClassType;
import com.cn.beans.common.ResultBean;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ClassTypeService {

    ResultBean insertClassType(ClassType classType);

    ResultBean updateClassType(ClassType classType);

    ResultBean deleteClassType(int classTypeId);

    PageInfo<ClassType> getClassTypeList(int start, int limit, String classTypeName);

    List<ClassType> getAllClassTypeList();
}
