package com.provider.model;

import java.io.Serializable;

public class Log implements Serializable {
    private Integer id;

    private String args;

    private String methodName;

    private String operate;

    private static final long serialVersionUID = 1L;

    public Log(Integer id, String args, String methodName, String operate) {
        this.id = id;
        this.args = args;
        this.methodName = methodName;
        this.operate = operate;
    }

    public Log() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args == null ? null : args.trim();
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName == null ? null : methodName.trim();
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate == null ? null : operate.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", args=").append(args);
        sb.append(", methodName=").append(methodName);
        sb.append(", operate=").append(operate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}