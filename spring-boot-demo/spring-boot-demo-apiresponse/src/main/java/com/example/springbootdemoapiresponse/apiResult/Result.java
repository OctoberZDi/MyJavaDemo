package com.example.springbootdemoapiresponse.apiResult;

import com.example.springbootdemoapiresponse.enums.ResultCode;

import java.io.Serializable;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: Result
 * @Description: 请求响应结果
 * @Author: zhangdi
 * @Date: 2020年11月02日 17:47
 **/
public class Result implements Serializable {
    private ResultCode resultCode;

    public void setResultCode(ResultCode code) {
        this.resultCode = code;
    }

    private Object data;

    public void setData(Object data) {
        this.data = data;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result success() {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    public static Result failure(ResultCode resultCode) {
        Result result = new Result();
        result.setResultCode(resultCode);
        return result;
    }

    public static Result failure(ResultCode resultCode, Object data) {
        Result result = new Result();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }
}
