package com.mjh.myojpro.controller;

import com.mjh.myojpro.enums.StatusCodeEnum;
import com.mjh.myojpro.model.Response;
import com.mjh.myojpro.model.pojo.User;
import com.mjh.myojpro.model.vo.UserVo;
import com.mjh.myojpro.service.UserService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    /**
     * 测试服务器连通性
     */
    @GetMapping("/user/ping")
    public void ping(){
        System.out.println("——————————————————————————————连接成功————————————————————————————");
    }
    @GetMapping("/user/login")
    public Response login(@RequestBody UserVo userVo){
        //System.out.println(userVo.toString());
        User user=new User();
        BeanUtils.copyProperties(userVo,user);
        userService.login(user);
        return new Response(StatusCodeEnum.SUCCESS,"登录成功",null);
    }
    @PostMapping("/user/register")
    public Response register(@RequestBody User user){
        //System.out.println(userVo.toString());

        userService.register(user);
        return new Response(StatusCodeEnum.SUCCESS,"注册成功",null);
    }
}
