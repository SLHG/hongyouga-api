package com.cn.service.impl.classpackage;

import com.cn.beans.classpackage.ClassPackageType;
import com.cn.beans.classpackage.ClientClassPackageInfo;
import com.cn.beans.common.ResultBean;
import com.cn.beans.common.Status;
import com.cn.dao.classpackage.ClassPackageTypeDao;
import com.cn.dao.classpackage.ClientClassPackageInfoDao;
import com.cn.service.classpackage.ClassPackageTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassPackageTypeServiceImpl implements ClassPackageTypeService {

    final ClassPackageTypeDao classPackageTypeDao;

    final ClientClassPackageInfoDao clientClassPackageInfoDao;


    public ClassPackageTypeServiceImpl(ClassPackageTypeDao classPackageTypeDao, ClientClassPackageInfoDao clientClassPackageInfoDao) {
        this.classPackageTypeDao = classPackageTypeDao;
        this.clientClassPackageInfoDao = clientClassPackageInfoDao;
    }

    @Override
    public void insertClassPackageType(ClassPackageType classPackageType) {
        classPackageType.setStatus(Status.NOT_ENABLE.getStatus());
        classPackageTypeDao.insertClassPackageType(classPackageType);
    }

    @Override
    public ResultBean updateClassPackageType(ClassPackageType classPackageType) {
        ClientClassPackageInfo clientClassPackageInfo = clientClassPackageInfoDao.getClientClassPackageInfoByPackageId(classPackageType.getPackageId(), Status.IS_ENABLE.getStatus());
        if (clientClassPackageInfo != null) {
            return new ResultBean(ResultBean.FAIL_CODE, "套餐在使用中,无法编辑");
        }
        int updateCount = classPackageTypeDao.updateClassPackageType(classPackageType);
        if (updateCount == 0) {
            return new ResultBean(ResultBean.FAIL_CODE, "更新失败");
        }
        return new ResultBean();
    }

    @Override
    public ResultBean deleteClassPackageType(int packageId) {
        ClientClassPackageInfo clientClassPackageInfo = clientClassPackageInfoDao.getClientClassPackageInfoByPackageId(packageId, Status.IS_ENABLE.getStatus());
        if (clientClassPackageInfo != null) {
            return new ResultBean(ResultBean.FAIL_CODE, "套餐在使用中,无法删除");
        }
        int updateCount = classPackageTypeDao.deleteClassPackageType(packageId, Status.NOT_ENABLE.getStatus());
        if (updateCount == 0) {
            return new ResultBean(ResultBean.FAIL_CODE, "删除失败");
        }
        return new ResultBean();
    }

    @Override
    public PageInfo<ClassPackageType> getClassPackageTypeList(int start, int limit, String packageName) {
        PageHelper.startPage(start, limit);
        List<ClassPackageType> list = classPackageTypeDao.getClassPackageTypeList(packageName);
        return new PageInfo<>(list);
    }
}
