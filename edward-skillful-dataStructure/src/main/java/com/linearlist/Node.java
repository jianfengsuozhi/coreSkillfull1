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
}
