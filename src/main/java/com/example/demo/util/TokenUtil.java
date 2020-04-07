package com.example.demo.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.sun.org.apache.xml.internal.security.algorithms.JCEMapper;
import io.jsonwebtoken.JwtBuilder;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TokenUtil {

    //token过期时间
    private static final long EXPIRE_TIME=15*60*1000;

    //token私钥
    private static final String TOKEN_SCRET="7e87f1b84aba40c790877a26cb4d8da4";
    public static String sign(String username,String userId){
        try {
            //过期时间
            Date date=new Date(System.currentTimeMillis()+EXPIRE_TIME);
            //私钥及加密算法
            Algorithm algorithm=Algorithm.HMAC256(TOKEN_SCRET);
            //设置头部信息
            Map<String,Object> hearder=new HashMap<>();
            hearder.put("typ","JWT");
            hearder.put("alg","HS256");
            //附带username，userId，生成签名
            return JWT.create().withHeader(hearder)
                    .withClaim("LoginName",userId)
                    .withClaim("UserrId",userId)
                    .withExpiresAt(date)
                    .sign(algorithm);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println( sign("name","ID").toString());
    }
}
