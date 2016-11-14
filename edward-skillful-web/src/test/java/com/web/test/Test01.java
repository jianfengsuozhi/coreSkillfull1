package com.web.test;

/**
 * Created by weideliang on 2016/11/3.
 */
public class Test01 {
    public static void main(String[] args) {
        int youNumber = 1;
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        String str = String.format("%04d", youNumber);

        System.out.println(str);

    }
}
