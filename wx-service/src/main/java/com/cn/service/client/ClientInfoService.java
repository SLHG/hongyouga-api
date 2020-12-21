package com.cn.service.client;

import com.cn.beans.client.ClientInfo;
import com.github.pagehelper.PageInfo;

public interface ClientInfoService {
    ClientInfo getClientInfoByOpenId(String openId);

    PageInfo<ClientInfo> getClientInfoList(int start, int limit, String clientName, String mobile);
}
