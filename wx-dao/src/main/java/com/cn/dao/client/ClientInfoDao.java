package com.cn.dao.client;

import com.cn.beans.client.ClientInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientInfoDao {
    ClientInfo getClientInfoByOpenId(String openId);

    List<ClientInfo> getClientInfoList(@Param("clientName") String clientName, @Param("mobile") String mobile);
}
