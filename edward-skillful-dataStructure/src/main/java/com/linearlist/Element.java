package com.linearlist;

/**
 * Created by weideliang on 2016/10/17.
 */
public class Element<T> {
    private int priority;
    private T data;

    public Element(int priority, T data) {
        this.priority = priority;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
