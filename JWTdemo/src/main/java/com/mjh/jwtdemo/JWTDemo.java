package com.mjh.jwtdemo;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.HashMap;

public class JWTDemo {
    public static final String SIGNATURE = "majiahui";
    public static void main(String[] args) {
        HashMap<String,String> claims = new HashMap<>();
        claims.put("username","mjh");
        claims.put("password","123456");
        String token = JWTUtils.getToken(claims);
        DecodedJWT decodedJWT = JWTUtils.parserToken(token);
        for(String claim : claims.keySet()){
            String value = decodedJWT.getClaim(claim).asString();
            System.out.println(claim+":"+value);
        }

    }
}
