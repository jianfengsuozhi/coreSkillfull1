package com.stack;

/**
 * 队列应用：使用多线程实现排队买票
 * 卖票窗口 每天只卖100张票
 * 利用队列实现排队功能
 * Created by Edward on 2016/10/16.
 */
public class QueueApplication01 {
    public Queue02<Integer> queue02 = new Queue02<Integer>();
    public Integer Sell_Sum = 10;
    public Integer count = 0;
    public boolean isAlive = true;

    /**
     * 排队买票:入队
     */
    public synchronized void waitToBugTicket() throws InterruptedException {
        if(count<Sell_Sum){
            System.out.println("第"+(count+1)+"个人排队等待买票");
            queue02.push(count++);
            this.notifyAll();
        }else {
            System.out.println("今天的票已卖完,请明天再买");
            this.wait();
        }
    }

    public synchronized void sellTicket() throws InterruptedException {
        if(!queue02.isEmpty()){
            Integer count = queue02.pop();
            System.out.println("第"+(count+1)+"个人已买票");
            this.notifyAll();
        }else{
            System.out.println("今天的票已卖完,请明天再买!!!");
            isAlive = false;
            this.wait();
        }
    }

    public static void main(String[] args) {
        QueueApplication01 queueApplication01 = new QueueApplication01();

        WaitToBuyTicket waitToBuyTicket = new WaitToBuyTicket(queueApplication01);
        SellTicket sellTicket = new SellTicket(queueApplication01);

        Thread waitThread = new Thread(waitToBuyTicket);
        Thread sellThread = new Thread(sellTicket);

        waitThread.start();
        sellThread.start();
    }
}
