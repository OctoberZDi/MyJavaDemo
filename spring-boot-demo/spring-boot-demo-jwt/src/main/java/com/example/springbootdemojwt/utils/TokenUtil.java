package com.example.springbootdemojwt.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.springbootdemojwt.data.User;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: TokenUtil
 * @Description: token util
 * @Author: zhangdi
 * @Date: 2020年04月11日 15:39
 **/
@Component
public class TokenUtil {
    /**
     * 获取token
     *
     * @param user
     * @return
     */
    public String getToken(User user) {
        String token = "";
        Date expiresAt = new Date(System.currentTimeMillis() + 24L * 60L * 3600L * 1000L);
        try {
            // Algorithm.HMAC256():使用HS256生成token,密钥则是用户的密码，唯一密钥的话可以保存在服务端。
            // withAudience()存入需要保存在token的信息
            token = JWT.create().withAudience(user.getUserid(), user.getPassword()).withExpiresAt(expiresAt).withIssuer("auth0").sign(Algorithm.HMAC256(user.getPassword()));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return token;
    }

    /**
     * 先验证token是否被伪造，然后解码token。
     *
     * @param token 字符串token
     * @return 解密后的DecodedJWT对象，可以读取token中的数据。
     */
    public DecodedJWT deToken(final String token, final String password) {
        DecodedJWT jwt = null;
        try {
            // 使用了HMAC256加密算法。
            // mysecret是用来加密数字签名的密钥。
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(password))
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
