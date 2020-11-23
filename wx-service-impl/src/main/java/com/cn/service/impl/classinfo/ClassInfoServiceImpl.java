package com.cn.service.impl.classinfo;

import com.cn.beans.classinfo.ClassInfo;
import com.cn.dao.classinfo.ClassInfoDao;
import com.cn.service.classinfo.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassInfoServiceImpl implements ClassInfoService {

    @Autowired
    ClassInfoDao classInfoDao;

    @Override
    public ClassInfo getClassInfoById(int classId) {
        return classInfoDao.getClassInfoById(classId);
    }
}
