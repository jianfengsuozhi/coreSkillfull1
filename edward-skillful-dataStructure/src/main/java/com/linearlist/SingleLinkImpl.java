package com.linearlist;

/**
 * 链表增删和删除时有3种情况：头,尾,中间
 * Created by weideliang on 2016/10/13.
 */
public class SingleLinkImpl<T> implements SingleLink<T>{
    private Node<T> header, tail;//头结点和尾结点
    private int size;//结点个数

    public SingleLinkImpl(){
        header = null;
        tail = null;
        size = 0;
    }

    /**
     * 创建头结点,只能创建一次:头结点就是第一个数据元素 size=0
     * @param element
     */
    public void addToHeader(T element){
        header = new Node<T>(element);
        tail = header;
        this.size++;
    }

    /**
     * 添加尾结点
     * @param element
     */
    public void addToTail(T element){
        if(!isEmpty()){
            Node<T> newTailNode = new Node<T>(element);
            tail.next = newTailNode;//next存储的是引用
            tail = tail.next;
            this.size++;
        }else {
            this.addToHeader(element);
        }
    }

    /**
     * 非空
     * @return
     */
    public boolean isEmpty(){
        return header == null;
    }

    /**
     * 插入
     */
    public void insert(int index,T element){
        if(0 == index){//头结点
            this.addToHeader(element);
            return;
        }
        if(size == index){//尾结点
            this.addToTail(element);
            return;
        }
       //先定位当前结点
        Node<T> currentNode = this.get(index - 1);
        //中间节点
        Node<T> newNode = new Node<T>(element);
        newNode.next = currentNode.next;
        currentNode.next = newNode;
        size++;
    }

    /**
     * 定位当前结点
     * @param index
     */
    public Node<T> get(int index){
        Node<T> current = header;

        int i = 0;
        while(i<index){
            current = current.next;
            i++;
        }
        return current;
    }

    @Override
    public void deleteHeader() {
       if(null == header){
           throw new RuntimeException("该链表为null,无法删除");
       }
        header = header.next;
        this.size--;
    }

    @Override
    public void deleteTail() {
        if(null == tail){
            throw new RuntimeException("该链表为null,无法删除");
        }
        Node<T> node = this.get(size - 2);
        this.tail = node;
        this.tail.next = null;
        this.size--;
    }

    @Override
    public void delete(int index) {
        if(0 == index){
            this.deleteHeader();
            return;
        }
        if((size-1) == index){
            this.deleteTail();
            return;
        }
        Node<T> beforeNode = this.get(index - 1);
        Node<T> deleteNode = this.get(index);
        beforeNode.next = deleteNode.next;
        this.size--;
    }

    @Override
    public int size() {
        return this.size;
    }

    public String print(){
        if(size != 0){
            Node<T> current = header;
            String str = "0:" + current.data + ",";
            int i = 0;
            while(i<size-1){
                current = current.next;
                i++;
                str = str + i + ":" + current.data + ",";
            }
            return str;
        }else {
            return "";
        }
    }

    public static void main(String[] args) {
        SingleLinkImpl<String> link01 = new SingleLinkImpl<>();
        link01.addToHeader("head01");
        link01.addToTail("tail01");
        link01.addToTail("tail02");
        link01.addToTail("tail03");

//        link01.delete(1);
//        link01.deleteHeader();
        link01.deleteTail();
    }

}
