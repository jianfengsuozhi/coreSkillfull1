package com.api.modelEx;

import java.io.Serializable;

/**
 * 选择框
 * Created by weideliang on 2016/9/27.
 */
public class CodeAndName implements Serializable{
    private String code;
    private String name;

    public CodeAndName() {
    }

    public CodeAndName(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
