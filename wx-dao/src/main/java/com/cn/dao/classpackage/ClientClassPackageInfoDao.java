package com.cn.dao.classpackage;

import com.cn.beans.classpackage.ClientClassPackageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientClassPackageInfoDao {
    ClientClassPackageInfo getClientClassPackageInfoByPackageId(@Param("packageId") int packageId, @Param("isEnable") int isEnable);
}
