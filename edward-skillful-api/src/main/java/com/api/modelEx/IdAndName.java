package com.api.modelEx;

import java.io.Serializable;

/**
 * Created by Edward on 2016/10/7.
 */
public class IdAndName implements Serializable{
    private Integer recordId;
    private String name;

    public IdAndName() {
    }

    public IdAndName(Integer recordId, String name) {
        this.recordId = recordId;
        this.name = name;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
