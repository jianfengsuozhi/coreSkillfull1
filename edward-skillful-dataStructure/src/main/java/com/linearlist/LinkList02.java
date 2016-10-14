package com.linearlist;

/**
 * 链表和顺序表的区别
 *     链表：访问不方便 长度任意 增加和删除不需要曾题移动
 * 最大的特点是
 *    递归代替循环
 *    对根结点的处理方法和对其他结点的处理方法一样
 * Created by weideliang on 2016/10/13.
 */
public class LinkList02 {
    private NodeLink root;//根节点
    private int size;//结点个数

    private int foot = 0;
    private String[] retData;//返回元素
    //增加和删除时重新遍历,其他操作不需要进行遍历
    private boolean changeFlag = true;

    //增加一个结点
    public void add(String data){
        if(null == data){
            throw new RuntimeException("结点不能为null");
        }
        NodeLink newNode = new NodeLink(data);

        if(null == root){
            root = newNode;
        }else {
            root.addNode(newNode);//必须保证root不能为Null,否则会报空指针异常
        }
        this.changeFlag = true;
        this.size++;
    }

    /**
     * 增加多个结点
     * @param dataArray
     */
    public void addAll(String[] dataArray){
        for (String str : dataArray) {
            this.add(str);
        }
    }

    public int size(){
        return this.size;
    }

    public boolean contains(String data){
        if(null == data){
            return false;
        }

        if(null == root){
            return false;
        }else{
            if(data.equals(root.data)){
                return true;
            }else {
                return root.contains(data);
            }
        }
    }

    public void removeFirst(String data){
        if(!contains(data)){
            return;
        }

        if(null == root){
            return;
        }else {
            if(root.data.equals(data)){
                root = root.next;
            }else{
                root.removeNode(data);
            }
        }
        this.changeFlag = true;
        this.size--;
    }

    public String[] toArray(){
        if(0 == this.size){
            return null;
        }
        this.foot = 0;

        if(changeFlag){
            this.retData = new String[this.size];

            if(null == this.root){
                return null;
            }else {
                LinkList02.this.retData[LinkList02.this.foot++] = root.data;
                this.root.toArrayNode();
            }
            this.changeFlag = false;
        }
        return this.retData;
    }

    /**
     * 特殊
     * @param index
     * @return
     */
    public String get(int index){
        if(index <0 || index>=size){
            throw new RuntimeException("index索引越界");
        }
        this.foot = 0;
        return this.root.getNode(index);
    }

    public void clear(){
        this.root = null;//断掉连接
        this.size = 0;
        this.changeFlag = true;
    }

    public void print(){
        if(null == root){
            return;
        }else {
            System.out.print(root.data);
            root.printNode();
            System.out.println();
        }
    }

    /**
     * 空链表：链表没有数据或根结点为null
     * @return
     */
    public boolean empty(){
        return this.size == 0;
    }

    /**
     * node做内部类的好处：专注于核心代码的书写
     */
    class NodeLink{
        private String data;
        private NodeLink next;

        public NodeLink(String data) {
            this.data = data;
            this.next = null;
        }

        /**
         * 递归:只有next为null时才能添加新结点
         * @param newData
         */
        public void addNode(NodeLink newData){
            if(null == this.next){
                this.next = newData;
            }else{
                this.next.addNode(newData);//this.next 下一个结点
            }
        }

        public boolean contains(String data){
            if(null == this.next){
                return false;
            }else{
                if(data.equals(this.next.data)){
                    return true;
                }else {
                    return this.next.contains(data);
                }
            }
        }

        //从删除结点之前的结点开始,目的为了好删除
        public void removeNode(String data){
            if(null == this.next){
                return;
            }else {
                if(this.next.data.equals(data)){
                    this.next = this.next.next;
                }else {
                    this.next.removeNode(data);
                }
            }
        }

        public void printNode(){
            if(null == this.next){
                return;
            }else {
                System.out.print("-->"+this.next.data);
                this.next.printNode();
            }
        }

        public void toArrayNode(){
            if(null == this.next){
                return;
            }else {
                LinkList02.this.retData[LinkList02.this.foot++] = this.next.data;
                this.next.toArrayNode();
            }
        }

        public String getNode(int index){
            if(LinkList02.this.foot ++ == index){//当前结点所在的index
                return this.data;
            }else {
                return this.next.getNode(index);
            }
        }

    }
}
