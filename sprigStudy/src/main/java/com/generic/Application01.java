package com.generic;

import org.springframework.util.Assert;

/**
 * Created by weideliang on 2017/2/13.
 */
public class Application01 {
    public static void main(String[] args) {
        //测试两者之间的最小值
        System.out.println(Application01.min(2,3));
        System.out.println(Application01.min(3.111,3.12));
        //
    }


    /**
     * 求两个数的最小值
     * @param a1
     * @param a2
     * @param <T>
     * @return
     */
    public static <T extends Comparable> T  min(T a1, T a2){
        Assert.notNull(a1,"a1 不能为Null");
        Assert.notNull(a2,"a2 不能为Null");
        if(a1.compareTo(a2) > 0){
            return a2;
        }
        return a1;
    }



}
