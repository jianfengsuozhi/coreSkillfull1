package com.sort;

/**
 *
 * Created by weideliang on 2016/10/24.
 */
public enum  SortEnum {
    FromMinToMax((short)1,"从小到大"),
    FromMaxToMin((short)2,"从大到小");

    private short value;
    private String name;

    SortEnum(short value, String name) {
        this.value = value;
        this.name = name;
    }

    public short getValue() {
        return value;
    }

    public void setValue(short value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
