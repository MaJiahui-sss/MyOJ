package com.mjh.myojpro.interceptor;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.mjh.myojpro.enums.StatusCodeEnum;
import com.mjh.myojpro.exception.BusinessException;
import com.mjh.myojpro.utils.JWTUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JWTInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        try{
            DecodedJWT decodedJWT = JWTUtils.parserToken(token);
            return true;
        }catch (Exception e){

            throw new BusinessException(StatusCodeEnum.UNAUTHORIZED,"用户登录状态异常，请重新登录");

        }


    }
}
