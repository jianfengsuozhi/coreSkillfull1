package com.stack;

/**
 * 排队买票
 * Created by weideliang on 2016/10/17.
 */
public class WaitToBuyTicket implements Runnable {
    private QueueApplication01 queueApplication01;

    public WaitToBuyTicket(QueueApplication01 queueApplication01) {
        this.queueApplication01 = queueApplication01;
    }

    @Override
    public void run() {
        while (queueApplication01.count < queueApplication01.Sell_Sum){
            try {
                queueApplication01.waitToBugTicket();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
