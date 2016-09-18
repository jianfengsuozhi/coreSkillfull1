package com.test;

/**
 * Created by weideliang on 2016/9/18.
 */
public class Test05 {
    public static void main(String[] args) {
        java.util.Date date = new java.util.Date();
        java.text.SimpleDateFormat sim = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = "";
        try {
            str = sim.format(date);
            System.out.println(str);
            Thread.sleep(300000); //1毫秒=60000分，这是5分钟触发一次
            str = sim.format(date.getTime()+300000);
            System.out.println(str);//转换后的时间格式
        } catch (Exception e) {//异常模块}
        }
    }

}
