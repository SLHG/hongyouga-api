package com.cn.service.client;

import com.cn.beans.client.ClientInfo;

public interface ClientInfoService {
    ClientInfo getClientInfoByOpenId(String openId);
}
