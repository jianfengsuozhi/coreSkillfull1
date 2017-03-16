package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试时间和字符串之间的转换
 * Created by weideliang on 2017/2/7.
 */
public class TestBetweenDateAndString {
    public static void main(String[] args) throws ParseException {
        //将字符串转化为时间  str--date:没有什么用  格式不正确
//        Date date1 = TestBetweenDateAndString.stringToDate("2017-06-10", "yyyy-MM-dd");
        Date date2 = TestBetweenDateAndString.stringToDate("2017-06-10", "yyyyMMdd");
        System.out.println(TestBetweenDateAndString.dateToString(date2, "yyyy-MM-dd"));


        //date-->String
//        System.out.println(TestBetweenDateAndString.dateToString(new Date(),"yyyy-MM-dd"));
        // date-->string-->date


    }

    public static Date stringToDate(String str, String pattern) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.parse(str);
    }

    public static String dateToString(Date date, String pattern) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }


}
