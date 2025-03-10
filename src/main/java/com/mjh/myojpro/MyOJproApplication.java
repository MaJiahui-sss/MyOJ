package com.mjh.myojpro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.mjh.myojpro.mapper")
public class MyOJproApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyOJproApplication.class, args);
    }

}
