package com.mjh.myojpro.model.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户状态  true 启用   false 禁用
     */
    private Boolean status;
    /**
     * 是否管理员
     */
    private Boolean isAdmin;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
