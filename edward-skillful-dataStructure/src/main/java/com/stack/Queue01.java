package com.stack;

/**
 * 队列：线性表 一端进行插入(队尾),另一端进行删除(队头)如树：  只是增加头和尾
 * 循环队列的数组实现方法：
 *    循环队列好处：
 * Created by Edward on 2016/10/16.
 */
public class Queue01<T> {
    private final int default_capacity = 3;
    //用数组保存元素
    private T[] elementData;
    //容量:数组大小
    private int capacity;
    //当前已插入元素的个数
    private int size;
    private int front;//队头
    private int rear;//队尾

    public Queue01(){
        elementData = (T[]) new Object[default_capacity];
        capacity = default_capacity;
        size = 0;
        front = 0;
        rear = 0;
    }

    public boolean isFull(){
        return size == elementData.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 扩容2倍：只改变容量,其他成员变量值不改变
     */
    public void resize(){
        this.capacity *= 2;
        T[] tmp = (T[]) new Object[capacity];
        System.arraycopy(elementData,0,tmp,0,elementData.length);
        elementData = tmp;
        tmp = null;//方便gc回收
    }

    public void push(T element){
        if(isFull()){
            resize();
        }
        elementData[rear % capacity] = element;
        rear++;
        size++;
    }

    public T pop(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        T element = elementData[front % capacity];
        front++;
        this.size--;
        return element;
    }

    public T peek(){
        if(isEmpty()){
            return null;
        }
        return elementData[front % capacity];
    }

    public static void main(String[] args) {
        Queue01<String> queue01 = new Queue01<>();
        queue01.push("q1");
        queue01.push("q2");
        queue01.push("q3");
        queue01.push("q4");
//        System.out.println(queue01.isEmpty());
//        System.out.println(queue01.peek());
//        System.out.println(queue01.pop());
//        System.out.println(queue01.pop());
//        System.out.println(queue01.pop());
//        System.out.println(queue01.isEmpty());
    }
}
