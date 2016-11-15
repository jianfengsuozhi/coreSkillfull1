package com.ioc;

/**
 * 同步方法与同步块的区别:执行效率 相同点:锁的是对象
 * 形象描述:一个对象 ==一个房子(房子的大门口有一把钥匙) 房子里有很多上锁的房间和没上锁的房间  访问一个上锁的房间后需要把钥匙放在大门口
 *
 * Created by weideliang on 2016/11/15.
 */
public class Thread3 {
    private String name="魏德亮";

    /**
     * 同步方法
     */
    public synchronized void testSyncMethod(){

    }

    public void testSync01(){
        synchronized (this){//调用这个方法的对象

        }
    }

    public void testSync02(){
        byte[] lock = new byte[0];
        synchronized (lock){//创建实例充当锁 零长度的byte数组对象创建起来将比任何对象节省空间 跨对象

        }
    }

    public void testSync02(String a){
        synchronized (a){//参数a

        }
    }



    //同步代码块
    public void printVal(){
        System.out.println("其他");
        synchronized (name){//name 对象必须填
            System.out.println(name);
        }
    }

    public static void main(String[] args) {
        final Thread3 thread3 = new Thread3();

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                thread3.printVal();
            }
        }, "A");
        a.start();
    }

}
