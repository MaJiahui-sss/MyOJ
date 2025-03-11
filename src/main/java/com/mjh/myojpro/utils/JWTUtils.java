package com.mjh.myojpro.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.util.Calendar;
import java.util.Map;

public class JWTUtils {
    public static final String SIGNATURE = "majiahui";
    public static String getToken(Map<String, String> claims){
        JWTCreator.Builder builder = JWT.create();
        for(String key : claims.keySet()){
            builder.withClaim(key, claims.get(key));
        }
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 30);
        builder.withExpiresAt(calendar.getTime());
        String token = builder.sign(Algorithm.HMAC256(SIGNATURE));
        return token;


    }
    public static DecodedJWT parserToken(String token){
        Algorithm algorithm = Algorithm.HMAC256(SIGNATURE);
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT jwt = verifier.verify(token);
        return jwt;
    }

}
