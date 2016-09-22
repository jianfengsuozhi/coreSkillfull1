package com.web.test;

import java.util.Date;

/**
 * Created by weideliang on 2016/9/20.
 */
public class User {
    private long id;
    private String name;
    private Date date;

    //必须
    public User() {
    }

    public User(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}