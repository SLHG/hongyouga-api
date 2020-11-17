package com.cn.service.impl;


import com.alibaba.fastjson.JSON;
import com.cn.beans.wx.User;
import com.cn.dao.UserMapper;
import com.cn.service.UserService;
import com.cn.service.config.DataType;
import com.cn.service.config.SelectDataSource;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userDao;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public User getUser(Integer id) {
        ValueOperations<String, Object> opsVal = redisTemplate.opsForValue();
        Object o = opsVal.get(String.valueOf(id));
        if (o != null) {
            return JSON.parseObject((String) o, User.class);
        }
        LOGGER.info("controller查询数据" + id);
        User user = userDao.getUser(id);
        if (user != null) {
            LOGGER.info("查询到的数据" + JSON.toJSONString(user));
            opsVal.set(String.valueOf(id), JSON.toJSONString(user), 600, TimeUnit.SECONDS);
        }
        return user;
    }

    @Override
    public PageInfo<User> getUserByName(String name) {
        PageHelper.startPage(1, 10);
        List<User> list = userDao.getUserByName(name);
        return new PageInfo<>(list);
    }

    @Override
    @SelectDataSource(DataType.SLAVE_SOURCE)
    public User getUserSlave(Integer id) {
        return userDao.getUser(id);
    }
}
