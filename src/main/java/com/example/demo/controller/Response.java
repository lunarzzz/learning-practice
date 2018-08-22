package com.example.demo.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author chenlongfei
 * 2017年8月30日
 */
public class Response<T> implements Serializable {

    public static final int SUCCESS_CODE = 200;

    private static final long serialVersionUID = -7839245552615253344L;

    private T data;

    private String retDesc;

    private int retCode;

    private Map<String, Object> extend = new HashMap<>();

    public Response() {}

    public Response(T data, int retCode, String retDesc) {
        this.data = data;
        this.retCode = retCode;
        this.retDesc = retDesc;
    }

    public void putExtendAll(Map<String, Object> map) {
        extend.putAll(map);
    }

    public void putExtendEntry(String key, Object value) {
        extend.put(key, value);
    }

    public <T> T getExtendEntry(String key) {
        return (T)extend.get(key);
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public boolean isSuccess() {
        return retCode == SUCCESS_CODE;
    }

    public String getRetDesc() {
        return retDesc;
    }

    public void setRetDesc(String retDesc) {
        this.retDesc = retDesc;
    }

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
