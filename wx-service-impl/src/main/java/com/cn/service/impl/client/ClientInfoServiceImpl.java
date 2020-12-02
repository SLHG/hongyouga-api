package com.cn.service.impl.client;

import com.cn.beans.client.ClientInfo;
import com.cn.dao.client.ClientInfoDao;
import com.cn.service.client.ClientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 客户信息
 */
@Service
public class ClientInfoServiceImpl implements ClientInfoService {

    @Autowired
    ClientInfoDao clientInfoDao;

    @Override
    public ClientInfo getClientInfoByOpenId(String openId) {
        return clientInfoDao.getClientInfoByOpenId(openId);
    }
}
