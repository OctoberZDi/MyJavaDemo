package com.example.springbootdemo.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: Decrypt
 * @Description: dd
 * @Author: zhangdi
 * @Date: 2020年04月10日 18:01
 **/
public final class Decrypt {

    /**
     * 先验证token是否被伪造，然后解码token。
     *
     * @param token 字符串token
     * @return 解密后的DecodedJWT对象，可以读取token中的数据。
     */
    public DecodedJWT deToken(final String token) {
        DecodedJWT jwt = null;
        try {
            // 使用了HMAC256加密算法。
            // mysecret是用来加密数字签名的密钥。
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256("mysecret"))
                    .withIssuer("auth0")
                    .build(); //Reusable verifier instance
            jwt = verifier.verify(token);
        } catch (JWTVerificationException | IllegalArgumentException | UnsupportedEncodingException exception) {
            //Invalid signature/claims
            exception.printStackTrace();
        } // TODO Auto-generated catch block
        // TODO Auto-generated catch block

        return jwt;
    }
}
