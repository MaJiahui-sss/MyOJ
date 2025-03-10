package com.mjh.myojpro.exception;

import com.mjh.myojpro.enums.StatusCodeEnum;
import lombok.Data;

@Data
public class BusinessException extends RuntimeException {
    private StatusCodeEnum statusCode;
    private String message;
    public BusinessException(StatusCodeEnum statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
