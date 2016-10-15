package com.linearlist;

/**
 * Created by weideliang on 2016/10/13.
 */
public class Node<T>{
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T data() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> next() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
