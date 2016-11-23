package com.ioc;

/**
 * 同一对象 同步方法(对象锁)：只允许有一个线程访问,只有当该线程执行完同步块的代码,其他线程才能访问
 *                         只要有一个访问该线程的同步方法,其他线程不能访问该对象的同步方法,但可访问该对象的其他非同步方法
 * Created by weideliang on 2016/11/15.
 */
public class Thread1 implements Runnable{
    @Override
    public void run() {
        synchronized (this){//调用这个方法的对象
            for(int i=0; i<10; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"   loop:"+i);
            }
        }
    }

    public synchronized  void testSyn(){
        for(int i=0; i<10; i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"   loop:"+i);
        }
    }

    public synchronized  static   void testClassSyn(){
        for(int i=0; i<10; i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"   loop:"+i);
        }
    }



    public void testNotSyn(){
        for(int i=0; i<10; i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"   loop:"+i);
        }
    }

    public static void main(String[] args) {
//        Thread1 thread1 = new Thread1();
//
//        Thread a = new Thread(thread1, "A");
//        Thread b = new Thread(thread1, "B");
//
//        a.start();
//        b.start();

        final Thread1 thread1 = new Thread1();
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                thread1.run();
            }
        },"a");

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
//                thread1.testNotSyn();
//                thread1.testSyn();
                Thread1.testClassSyn();//类锁方法和对象锁方法 交错进行
            }
        },"b");

        a.start();
        b.start();
    }
}
