package com.mjh.myojpro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mjh.myojpro.model.pojo.User;

/**
* @author Ma Jiahui
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2025-03-10 17:03:36
*/
public interface UserService extends IService<User> {
    public String login(User user);
    public boolean register(User user);
}
