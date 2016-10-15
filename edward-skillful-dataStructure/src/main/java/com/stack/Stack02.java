package com.stack;

import com.linearlist.Node;
import com.sun.xml.internal.ws.model.RuntimeModelerException;

/**
 * 利用链表实现栈
 *  插入和删除的一段叫栈顶
 * Created by weideliang on 2016/10/14.
 */
public class Stack02<T> {
    private Node top;
    private int size;

    public Stack02(){
        this.size = 0;
    }
    public Stack02(T element){
        top = new Node(element, null);
        this.size++;
    }

    /**
     * 新结点就是top,旧结点跟在新节点的后面
     * @param element
     */
    public void push(T element){
        top = new Node(element, top);
        size++;
    }

    /**
     * 出栈:取出并删除
     * @return
     */
    public T pop(){
        if(this.size == 0){
            throw new RuntimeModelerException("队列已空");
        }
        T newTop = (T)top.data();
        this.size--;
        top = top.next();
        return newTop;
    }

    /**
     * 只取出,不删除
     * @return
     */
    public String peep(){
        return (String) top.data();
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        return this.size == 0;
    }

    public static void main(String[] args) {
        Stack02 stack02 = new Stack02();
        stack02.push("str1");
        stack02.push("str2");
        stack02.push("str3");

//        System.out.println(stack02.isEmpty());
        System.out.println(stack02.peep());
//        System.out.println(stack02.pop());
//        System.out.println(stack02.pop());
//        System.out.println(stack02.pop());
//        System.out.println(stack02.isEmpty());
    }
}
