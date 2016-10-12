package com.linearlist;

/**
 * Created by weideliang on 2016/10/12.
 */
public class LinkedImpl<T> implements Linked{
    private Node head;//头结点
    private Node current;//当前结点
    private int size;//结点个数

    @Override
    public void insert(int index, Object element) {
        if(index <0 || index >= size){
            throw new IndexOutOfBoundsException("索引越界");
        }

    }
}
