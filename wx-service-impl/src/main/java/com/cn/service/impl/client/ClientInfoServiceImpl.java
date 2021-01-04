package com.cn.service.impl.client;

import com.cn.beans.client.ClientInfo;
import com.cn.dao.client.ClientInfoDao;
import com.cn.service.client.ClientInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 客户信息
 */
@Service
public class ClientInfoServiceImpl implements ClientInfoService {

    final ClientInfoDao clientInfoDao;

    public ClientInfoServiceImpl(ClientInfoDao clientInfoDao) {
        this.clientInfoDao = clientInfoDao;
    }

    @Override
    public ClientInfo getClientInfoByOpenId(String openId) {
        return clientInfoDao.getClientInfoByOpenId(openId);
    }

    @Override
    public PageInfo<ClientInfo> getClientInfoList(int start, int limit, String clientName, String mobile) {
        PageHelper.startPage(start, limit);
        List<ClientInfo> list = clientInfoDao.getClientInfoList(clientName, mobile);
        return new PageInfo<>(list);
    }
}
