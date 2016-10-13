package com.linearlist;

/**
 * Created by weideliang on 2016/10/13.
 */
public interface SingleLink<T> {
    //增加
    void addToHeader(T element);

    void addToTail(T element);

    void insert(int index, T element);

    //删除
    void deleteHeader();

    void deleteTail();

    void delete(int index);

    //获取指定位置的元素
    Node<T> get(int index);

    //其他
    boolean isEmpty();

    int size();

    String print();
}
