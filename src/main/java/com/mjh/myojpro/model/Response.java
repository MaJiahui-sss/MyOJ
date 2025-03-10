package com.mjh.myojpro.model;


import com.mjh.myojpro.enums.StatusCodeEnum;
import lombok.Data;

@Data
public class Response<T> {
    private StatusCodeEnum code;
    private String msg;
    private T data;

    public Response(StatusCodeEnum code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }



    public Response(StatusCodeEnum code) {
        this.code = code;
    }

    public Response(StatusCodeEnum code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }
}
