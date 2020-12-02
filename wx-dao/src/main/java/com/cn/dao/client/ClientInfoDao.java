package com.cn.dao.client;

import com.cn.beans.client.ClientInfo;

public interface ClientInfoDao {
    ClientInfo getClientInfoByOpenId(String openId);
}
