package com.linearlist;

/**
 * 开发可用结点
 * Created by weideliang on 2016/10/13.
 */
public class LinkList {
    private NodeLink root;//根节点

    //增加一个结点
    public void add(String data){
        if(null == data){
            throw new RuntimeException("结点不能为null");
        }
        NodeLink newNode = new NodeLink(data);
        if(null == root){
            root = newNode;
        }else {
            root.addNode(newNode);
        }
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

    }
}
