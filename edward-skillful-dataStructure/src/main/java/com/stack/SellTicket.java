package com.stack;

/**
 * 买票
 * Created by weideliang on 2016/10/17.
 */
public class SellTicket implements Runnable{
    private QueueApplication01 queueApplication01;

    public SellTicket(QueueApplication01 queueApplication01) {
        this.queueApplication01 = queueApplication01;
    }

    @Override
    public void run() {
        while(queueApplication01.isAlive){
            try {
                queueApplication01.sellTicket();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
