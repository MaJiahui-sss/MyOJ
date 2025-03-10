package com.mjh.myojpro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/user/ping")
    public void ping(){
        System.out.println("——————————————————————————————连接成功————————————————————————————");
    }
}
