package com.example.demo.controller;

import java.util.Map;

/**
 *
 * @author chenlongfei 2017年8月30日
 */
public class ResponseBuilder<T> {

    private static final int DEFAULT_ERROR_CODE = -1;
    private static final String DEFAULT_ERROR_MSG = "系统错误";

    private Response<T> response = new Response<>();

//    public ResponseBuilder<T> buildFail(PmsPromotionError error) {
//        response.setRetCode(error.getCode());
//        response.setRetDesc(error.getMessage());
//        return this;
//    }

    public ResponseBuilder<T> buildSuccess(T result) {
        response.setRetCode(Response.SUCCESS_CODE);
        response.setData(result);
        return this;
    }

    public ResponseBuilder<T> buildSuccess(String message) {
        response.setRetCode(Response.SUCCESS_CODE);
        response.setRetDesc(message);
        return this;
    }

//    public ResponseBuilder<T> buildFail(PromotionComposeException exception) {
//        response.setRetCode(exception.getCode());
//        response.setRetDesc(exception.getMessage());
//        return this;
//    }

    public ResponseBuilder<T> buildFail(int code, String message) {
        response.setRetCode(code);
        response.setRetDesc(message);
        return this;
    }

    public ResponseBuilder<T> buildFail(String message) {
        response.setRetCode(DEFAULT_ERROR_CODE);
        response.setRetDesc(message);
        return this;
    }

    public ResponseBuilder<T> buildDefaultFail() {
        response.setRetCode(DEFAULT_ERROR_CODE);
        response.setRetDesc(DEFAULT_ERROR_MSG);
        return this;
    }

    public Response<T> getResponse() {
        return response;
    }

    public ResponseBuilder<T> build(int code, String message, Map<String, Object> extendMap) {
        response.setRetCode(code);
        response.setRetDesc(message);
        response.putExtendAll(extendMap);
        return this;
    }

}
