package com.linearlist;

/**
 * 实现单链表、
 * 头节点的数据域：为null或记录链表长度 此节点不计入链表长度
 * Created by weideliang on 2016/10/12.
 */
public interface Linked<T> {
    //插入元素
    void insert(int index,T element);
}
