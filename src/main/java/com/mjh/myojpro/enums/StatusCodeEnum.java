package com.mjh.myojpro.enums;

public enum StatusCodeEnum {
    SUCCESS(200,"成功"),
    UNAUTHORIZED(401,"权限校验失败"),
    NOT_FOUND(404,"资源未找到"),
    INTERNAL_SERVER_ERROR(500,"服务器内部异常"),
    PARAMS_ERROR(600,"参数错误");

    private int code;
    private String msg;
    StatusCodeEnum() {
    }
    StatusCodeEnum(int code) {
        this.code = code;
    }
    StatusCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
