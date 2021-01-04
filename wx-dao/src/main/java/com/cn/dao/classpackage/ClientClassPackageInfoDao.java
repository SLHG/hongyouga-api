package com.cn.dao.classpackage;

import com.cn.beans.classpackage.ClientClassPackageInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientClassPackageInfoDao {
    ClientClassPackageInfo getClientClassPackageInfoByPackageId(int packageId);
}
