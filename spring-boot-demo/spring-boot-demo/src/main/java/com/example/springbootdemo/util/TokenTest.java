package com.example.springbootdemo.util;

import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: TokenTest
 * @Description: token test
 * @Author: zhangdi
 * @Date: 2020年04月10日 18:01
 **/
public class TokenTest {
    public static void main(String[] args) {
        // 生成token
        Encrypt encrypt = new Encrypt();
        String token = encrypt.getToken(true, "zhangdi03", "张迪");
        // 打印token
        System.out.println("token: " + token);
        // 解密token
        Decrypt decrypt = new Decrypt();
        DecodedJWT jwt = decrypt.deToken(token);
        System.out.println("issuer: " + jwt.getIssuer());
        System.out.println("isVip:  " + jwt.getClaim("isVip").asBoolean());
        System.out.println("username: " + jwt.getClaim("username").asString());
        System.out.println("name:     " + jwt.getClaim("name").asString());
        System.out.println("过期时间：      " + jwt.getExpiresAt());
        System.out.println("*********");
    }
}
