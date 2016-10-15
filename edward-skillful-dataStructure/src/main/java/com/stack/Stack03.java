package com.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 容器实现栈
 * Created by Edward on 2016/10/15.
 */
public class Stack03<T> {
    private List<T> list;

    public Stack03(){
        list = new ArrayList<T>();
    }

    public void push(T data){
        list.add(data);
    }

    public T pop(){
        T element = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return element;
    }

    public boolean isEmpty(){
        return list.size() == 0;
    }

    public T peek(){
        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        Stack03<String> stack03 = new Stack03<>();
        stack03.push("str1");
        stack03.push("str2");
        stack03.push("str3");

        System.out.println(stack03.isEmpty());
        System.out.println(stack03.peek());
        System.out.println(stack03.pop());
        System.out.println(stack03.pop());
        System.out.println(stack03.pop());
        System.out.println(stack03.isEmpty());
    }
}
