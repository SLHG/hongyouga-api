package com.cn.web;


import com.cn.beans.User;
import com.cn.service.UserService;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public User getUser(Integer id) {
        LOGGER.info("service查询信息" + id);
        return userService.getUser(id);
    }

    @GetMapping("/getUserByName")
    public PageInfo<User> getUserByName(String name) {
        LOGGER.info("service查询信息" + name);
        return userService.getUserByName(name);
    }

    @GetMapping("/getUserSlave")
    public User getUserSlave(Integer id) {
        LOGGER.info("service查询信息" + id);
        return userService.getUserSlave(id);
    }
}
