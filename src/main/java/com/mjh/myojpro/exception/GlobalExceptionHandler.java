package com.mjh.myojpro.exception;

import com.mjh.myojpro.enums.StatusCodeEnum;
import com.mjh.myojpro.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public Response<?> handler(RuntimeException e) {
        log.error(e.getMessage(), e);
        return new Response<>(StatusCodeEnum.INTERNAL_SERVER_ERROR,"服务器错误");
    }
    @ExceptionHandler(BusinessException.class)
    public Response<?> handler(BusinessException e) {
        //log.error(e.getMessage(), e);
        return new Response<>(e.getStatusCode(),e.getMessage());
    }
}
