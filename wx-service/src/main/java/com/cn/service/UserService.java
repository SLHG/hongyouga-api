package com.cn.service;


import com.cn.beans.User;
import com.github.pagehelper.PageInfo;

public interface UserService {
    User getUser(Integer id);

    PageInfo<User> getUserByName(String name);

    User getUserSlave(Integer id);
}
