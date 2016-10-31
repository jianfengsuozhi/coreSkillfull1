package com.utils;


import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * 前端ajax调用时，返回的消息，表示本次ajax调用是否成功
 */
@SuppressWarnings("serial")
public class JsonData implements Serializable {

    public static final Integer STATUS_SUCCESS = 0;
    public static final Integer STATUS_FAIL = 1;
    public static final String STATUS_SUCCESS_MSG = "操作成功";
    // 0 - 成功， 其他值 - 失败
    private Integer status = STATUS_SUCCESS;
    private String msg;
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL) //{"name"："name","sex":null} -->{"name"："name"}
    private Object data;

    public JsonData() {
    }

    public JsonData(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 获取给定错误消息的失败状态的JsonMessage {"status":1,"msg":"操作失败"}
     */
    public static JsonData getFailed(String msg) {
        return new JsonData(STATUS_FAIL, msg, null);
    }

    /**
     * 获取给定结果对象的成功状态的JsonMessage {"status":0,"msg":"操作成功","data":{"name":"魏德亮"}}
     */
    public static JsonData getSucceed() {
        return new JsonData(STATUS_SUCCESS, STATUS_SUCCESS_MSG, null);
    }

    public static JsonData getSucceed(Object data) {
        return new JsonData(STATUS_SUCCESS, STATUS_SUCCESS_MSG, data);
    }

    public static JsonData getSucceed(String msg, Object data) {
        return new JsonData(STATUS_SUCCESS, msg, data);
    }

    public Integer getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

}
