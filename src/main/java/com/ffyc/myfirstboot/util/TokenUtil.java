package com.ffyc.myfirstboot.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {
   /* 创建生成token的方法*/
    public static String token (Integer id, String account,Integer type){
        String token = "";
        try {
            //过期时间 为1970.1.1 0:0:0 至 过期时间  当前的毫秒值 + 有效时间
            Date expireDate = new Date(new Date().getTime() + 10000*1000);
            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256("ZCEQIUBFKSJBFJH2020BQWE");
            //设置头部信息
            Map<String,Object> header = new HashMap<>();
            header.put("typ","JWT");
            header.put("alg","HS256");
            //携带id，账号信息，生成签名
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("id",id)
                    .withClaim("account",account)
                    .withClaim("type",type)
                    .withExpiresAt(expireDate)
                    .sign(algorithm);
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
        return token;
    }
    /*验证token是否有效*/
    public static boolean verify(String token){
        try {
            //验签
            Algorithm algorithm = Algorithm.HMAC256("ZCEQIUBFKSJBFJH2020BQWE");
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception e) {//当传过来的token如果有问题,抛出异常
            return false;
        }
    }
   /* 获得token 中playload部分数据*/
    public static DecodedJWT getTokenInfo(String token){
        return JWT.require(Algorithm.HMAC256("ZCEQIUBFKSJBFJH2020BQWE")).build().verify(token);
    }
}
