package com.cn.service.impl.classinfo;

import com.cn.beans.classinfo.ClassInfo;
import com.cn.beans.classinfo.ClassType;
import com.cn.beans.common.ResultBean;
import com.cn.beans.common.Status;
import com.cn.dao.classinfo.ClassInfoDao;
import com.cn.dao.classinfo.ClassTypeDao;
import com.cn.service.classinfo.ClassTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassTypeServiceImpl implements ClassTypeService {

    final ClassTypeDao classTypeDao;
    final ClassInfoDao classInfoDao;

    public ClassTypeServiceImpl(ClassTypeDao classTypeDao, ClassInfoDao classInfoDao) {
        this.classTypeDao = classTypeDao;
        this.classInfoDao = classInfoDao;
    }

    @Override
    public ResultBean insertClassType(ClassType classType) {
        int count = classTypeDao.getClassTypeCountByName(classType);
        if (count == 1) {
            return new ResultBean(ResultBean.FAIL_CODE, "名称重复,新增失败");
        }
        classTypeDao.insertClassType(classType);
        return new ResultBean();
    }

    @Override
    public ResultBean updateClassType(ClassType classType) {
        if (StringUtils.isBlank(classType.getClassTypeName())) {
            return new ResultBean(ResultBean.FAIL_CODE, "名称为空");
        }
        int countByName = classTypeDao.getClassTypeCountByName(classType);
        if (countByName == 1) {
            return new ResultBean(ResultBean.FAIL_CODE, "名称重复,更新失败");
        }
        int updateCount = classTypeDao.updateClassType(classType);
        if (updateCount == 1) {
            return new ResultBean();
        }
        return new ResultBean(ResultBean.FAIL_CODE, "更新失败");
    }

    @Override
    public ResultBean deleteClassType(int classTypeId) {
        ClassInfo classInfo = classInfoDao.getClassInfoByType(classTypeId, Status.IS_ENABLE.getStatus());
        if (classInfo != null) {
            return new ResultBean(ResultBean.FAIL_CODE, "使用中,无法删除");
        }
        int deleteCount = classTypeDao.deleteClassType(classTypeId);
        if (deleteCount == 1) {
            return new ResultBean();
        }
        return new ResultBean(ResultBean.FAIL_CODE, "删除失败");
    }

    @Override
    public PageInfo<ClassType> getClassTypeList(int start, int limit, String classTypeName) {
        PageHelper.startPage(start, limit);
        List<ClassType> list = classTypeDao.getClassTypeList(classTypeName);
        return new PageInfo<>(list);
    }

    @Override
    public List<ClassType> getAllClassTypeList() {
        return classTypeDao.getAllClassTypeList();
    }

}
