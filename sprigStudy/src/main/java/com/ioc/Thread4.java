package com.ioc;

/**
 * 如果一个类中定义了一个synchronized的static函数A，也定义了一个synchronized 的instance函数B，那么这个类的同一对象Obj
 *     在多线程中分别访问A和B两个方法时，不会构成同步,因为它们的锁都不一样.A方法的锁是Obj这个对象，而B的锁是Obj所属的那个Class
 * 类同步方法 非类同步方法(对象同步方法,非对象同步方法)
 * Created by weideliang on 2016/11/15.
 */
public class Thread4 {

    public synchronized static void methodAAA(){//同步的static 函数methodAAA与methodBBB等效:锁的是类,不是对象

    }

    public void methodBBB(){
        synchronized (Thread4.class){

        }
    }
}
