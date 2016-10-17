package com.linearlist;


/**
 * 优先级链表:优先级最高的数据先取出,优先级相等按先进先出取出
 * 和普通队列的区别：入队没区别,出队去优先级最高的元素 数值越小,优先级越高(如班级排名)
 */
public class LinkApplication01 {
    private SingleLink01<Element<String>> singleLink01 = new SingleLinkImpl<>();

    /**
     * 插入
     */
    public void push(Element<String> element){
        singleLink01.addToTail(element);
    }

    /**
     *取出:取出优先级最高的元素
     */
    public Element<String> pop(){
        //得到值和index
        Element<String> data = singleLink01.get(0).data;
        int priorityIndex = 0;
        for(int i=0; i<singleLink01.size(); i++){
            if(data.getPriority() > singleLink01.get(i).data.getPriority()){
                data = singleLink01.get(i).data;
                priorityIndex = i;
            }
        }
        //删除序号
        singleLink01.delete(priorityIndex);
        return data;
    }

    public Element<String> peek(){
        Element<String> data = singleLink01.get(0).data;
        for(int i=0; i<singleLink01.size(); i++){
            if(data.getPriority() > singleLink01.get(i).data.getPriority()){
                data = singleLink01.get(i).data;
            }
        }
        return data;
    }

    public boolean isEmpty(){
        return singleLink01.size() == 0;
    }

    public static void main(String[] args) {
        LinkApplication01 linkApplication01 = new LinkApplication01();
        linkApplication01.push(new Element<String>(3,"str3"));
        linkApplication01.push(new Element<String>(2,"str21"));
        linkApplication01.push(new Element<String>(2,"str22"));
        linkApplication01.push(new Element<String>(1,"str1"));

        System.out.println("按顺序出队");
        while (!linkApplication01.isEmpty()) {
            Element<String> pop = linkApplication01.pop();
            System.out.println("优先级:"+pop.getPriority()+",数据:"+pop.getData());
        }
    }
}
