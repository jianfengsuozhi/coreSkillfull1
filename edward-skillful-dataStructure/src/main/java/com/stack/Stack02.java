package com.stack;

import com.linearlist.Node;

/**
 * 利用链表实现栈
 *  插入和删除的一段叫栈顶
 * Created by weideliang on 2016/10/14.
 */
public class Stack02<T> {
    private Node<T> head;
    private int size;

    public void push(T element){
        head = new Node(element,head);
        size++;
    }
}
