package com.example.springbootdemoapiresponse.enums;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: ResultCode
 * @Description: 状态码信息枚举类
 * @Author: zhangdi
 * @Date: 2020年11月02日 17:41
 **/
public enum ResultCode {
    /**
     * 枚举code和信息
     */
    SUCCESS(1, "成功"),
    PARAM_IS_INVALID(1001, "参数无效！"),
    USER_NOT_LOGIN_IN(2001, "用户未登录，请登录");

    private final Integer code;
    private final String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
