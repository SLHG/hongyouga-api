package com.cn.dao;


import com.cn.beans.User;

import java.util.List;

public interface UserMapper {
    User getUser(Integer id);

    List<User> getUserByName(String name);
}
