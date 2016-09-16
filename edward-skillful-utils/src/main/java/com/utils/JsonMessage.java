package com.utils;

import java.io.Serializable;

@SuppressWarnings("serial")
public class JsonMessage implements Serializable {

    public static final Integer STATUS_SUCCESS = 0;
    public static final Integer STATUS_FAIL = 1;

    /** 会话过期 */
    public static final Integer STATUS_SESSION_EXPIRATION = 2;

    // 0 - 成功， 其他值 - 失败
    private Integer status = STATUS_SUCCESS;
    private String msg;
    // 错误信息。当status = 1时，有值。
    private String errorMsg;
    // 结果集
    private Object result;

    public JsonMessage() {

    }

    public JsonMessage(Integer status, Object result){
        this.status = status;
        this.result = result;
    }

    public JsonMessage(String errorMsg) {

        this.status = STATUS_FAIL;
        this.errorMsg = errorMsg;
        this.msg = errorMsg;
    }

    public JsonMessage(Integer status, String msg, String errorMsg, Object result) {

        super();
        this.status = status;
        this.msg = msg;
        this.errorMsg = errorMsg;
        this.result = result;
    }

    /**
     * 获取给定错误消息的失败状态的JsonMessage
     *
     * @author jiaomingyang
     * @version v2.0.9
     * @date 2014年7月7日 下午6:04:49
     *
     * @param errorMsg
     * @return
     */
    public static JsonMessage getFailed(String errorMsg) {
        return new JsonMessage(STATUS_FAIL,errorMsg,errorMsg,null);
    }

    /**
     * 获取给定结果对象的成功状态的JsonMessage
     *
     * @author jiaomingyang
     * @version v2.0.9
     * @date 2014年7月7日 下午6:05:25
     *
     * @param result
     * @return
     */
    public static JsonMessage getSucceed(Object result) {
        return new JsonMessage(STATUS_SUCCESS,null,null,result);
    }

    public Integer getStatus() {

        return status;
    }

    public void setStatus(Integer status) {

        this.status = status;
    }

    public String getErrorMsg() {

        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {

        this.errorMsg = errorMsg;
    }

    public String getMsg() {

        return msg;
    }

    public void setMsg(String msg) {

        this.msg = msg;
    }

    public Object getResult() {

        return result;
    }

    public void setResult(Object result) {

        this.result = result;
    }
}

