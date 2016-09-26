package com.web.test;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by weideliang on 2016/9/20.
 */
public class User implements Serializable{
    private Integer id;
    private String name;
    private Date date;

    //必须
    public User() {
    }

    public User(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
