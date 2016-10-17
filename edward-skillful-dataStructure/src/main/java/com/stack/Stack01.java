package com.stack;

/**
 * 栈是线性表的特例
 *  利用数组实现
 *  如何保证倒序取:数组倒着取
 *  栈底和栈顶
 * Created by weideliang on 2016/10/14.
 */
public class Stack01<T> {
    private Object[] array;
    private int defaultCapacity = 20;
    private int capacity;
    private int size;

    public Stack01(){
        this.init(defaultCapacity);
    }

    public Stack01(int capacity){
        this.init(capacity);
    }

    private void init(int capacity){
        this.array = new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    /**
     * 入栈
     */
    public void push(T element){
        if(size >= capacity){
            throw new RuntimeException("栈已满");
        }
        array[size++] = element;
    }

    public void pushAll(T[] elements){
        for (T element : elements) {
            this.push(element);
        }
    }

    /**
     * 出栈
     */
    public T pop(){
        if(0 == size){
            throw new RuntimeException("栈中没有数据");
        }
        return (T)array[--size];
    }

    public T peek(){
        if(0 == size){
            throw new RuntimeException("栈中没有数据");
        }
        return (T)array[size - 1];
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
        Stack01<String> stack01 = new Stack01<>();
        stack01.push("aa");
        stack01.push("bb");
        System.out.println(stack01.isEmpty());
        System.out.println(stack01.pop());
        System.out.println(stack01.pop());
        System.out.println(stack01.isEmpty());
    }
}
