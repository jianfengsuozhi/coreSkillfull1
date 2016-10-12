package com.linearlist;

/**
 * 利用数组实现顺序线性表：顺序表
 * 最大的特点:插入和删除时需要整体移动
 * Created by weideliang on 2016/10/12.
 */
public interface Array<T> {
    //增加
    void append(T element); //追加

    void insert(int index,T element);//插入

    //删除
    void delete(int  index);

    void clear();

    //修改
    T set(int index, T element);

    //查询
    T get(int index);

    //其他
    int length();
}
