package com.stack;

import com.linearlist.Node;

/**
 * 循环链表：链表实现
 * Created by Edward on 2016/10/16.
 */
public class Queue02<T> {
    private Node<T> head;
    private Node<T> rear;
    private int size;

    public boolean isEmpty(){
        return size == 0;
    }

    public void push(T element){
        if(isEmpty()){
            head = new Node<T>(element);
            rear = head;
            size++;
        }else {
            Node<T> tNode = new Node<>(element);
            rear.setNext(tNode);
            rear = rear.next();
            this.size++;
        }
    }

    public void pushAll(T[] elements){
        for (T element : elements) {
            this.push(element);
        }
    }

    public T pop(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        T data = head.data();
        head = head.next();
        this.size--;
        return data;
    }

    public T peek(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return head.data();
    }

    public static void main(String[] args) {
        Queue02<String> queue02 = new Queue02<>();
        queue02.push("q1");
        queue02.push("q2");
        queue02.push("q3");
        System.out.println(queue02.isEmpty());
        System.out.println(queue02.peek());
        System.out.println(queue02.pop());
        System.out.println(queue02.pop());
        System.out.println(queue02.pop());
        System.out.println(queue02.isEmpty());
    }
}
