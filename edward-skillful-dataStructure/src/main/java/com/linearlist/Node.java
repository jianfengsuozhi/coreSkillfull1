package com.linearlist;

/**
 * 节点类
 * Created by weideliang on 2016/10/12.
 */
public class Node {
    private Object element;
    private Node next;

    //头结点的构造方法
    public Node(Node next){
        this.next = next;
    }

    public Node(Object element, Node next) {
        this.element = element;
        this.next = next;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
