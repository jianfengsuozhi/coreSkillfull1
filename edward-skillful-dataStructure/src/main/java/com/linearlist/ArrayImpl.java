package com.linearlist;

/**
 * Created by weideliang on 2016/10/12.
 */
public class ArrayImpl<T> implements Array {
    //默认容量
    private final int default_size = 3;
    //用数组保存元素
    private Object[] elementData;
    //容量:数组大小
    private int capacity;
    //当前已插入元素的个数
    private int size;

    public ArrayImpl(){
        capacity = default_size;
        size = 0;
        elementData = new Object[capacity];
    }

    public ArrayImpl(int capacity){
        this.size = 10;
        elementData = new Object[capacity];
    }

    @Override
    public void append(Object element) {
        if(null == element){
            throw new RuntimeException("元素不能为null");
        }
        this.ensureCapacity();
        elementData[size++] = element;
    }

    @Override
    public void delete(int index) {//int可以控制不能为null
        if(index<0 || index>=capacity){
            throw new IndexOutOfBoundsException("数组越界");
        }
        //先前移动
        for(int i=index+1;i<capacity;i++){
            elementData[i - 1] = elementData[i];
        }
        this.size--;
    }

    @Override
    public void clear() {
        this.size = 0;
    }

    @Override
    public void insert(int index, Object element) {
        if(index < 0 || index >=size){
            throw new IndexOutOfBoundsException("数组索引越界");
        }
        if(null == element){
            throw new RuntimeException("元素不能为null");
        }
        ensureCapacity();
        //整体向后移动  从后往前移动
        for(int i=this.size-1; i>=index; i--){
            elementData[i + 1] = elementData[i];
        }
        elementData[index] = element;
        this.size++;
    }

    @Override
    public T set(int index, Object element) {
        if(index < 0 || index >=size){
            throw new IndexOutOfBoundsException("数组索引越界");
        }
        Object oldObj = this.get(index);
        elementData[index] = element;
        return (T)oldObj;
    }

    @Override
    public T get(int index) {
        if(index <0 || index >= this.size){
            throw new IndexOutOfBoundsException("数组索引越界");
        }
        return (T)elementData[index];
    }

    @Override
    public int length() {
        return this.size;
    }

    /**
     * 数组容量不足,则容量扩展2倍
     */
    private void ensureCapacity(){
        if(size >= capacity){
            //容量扩展2倍
            this.capacity = this.capacity * 2;
            Object[] newElementData = new Object[this.capacity];
            //复制
            for (int i=0; i<elementData.length; i++){
                newElementData[i] = elementData[i];
            }
            this.elementData = newElementData;
        }
    }

    @Override
    public String toString() {
        String str = "";
        for(int i=0; i<this.size-1; i++){
            str += elementData[i];
            str += " ";
        }
        str += elementData[this.size-1];
        return str;
    }
}

