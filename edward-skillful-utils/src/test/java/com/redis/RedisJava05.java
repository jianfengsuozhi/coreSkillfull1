package com.redis;

import com.google.common.collect.Lists;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

/**
 * Created by weideliang on 2016/9/26.
 */
public class RedisJava05 {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("redisTest.xml");
        RedisUtils02 redisUtils02 = ctx.getBean("redisUtils02", RedisUtils02.class);

        //测试list
        ArrayList<String> list = Lists.newArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        redisUtils02.set("list",list,null);

        list.clear();
        redisUtils02.set("list",list,null);

        ArrayList<String> valueList = (ArrayList<String>) redisUtils02.get("list");
        for (String str : valueList) {
            System.out.println(str);
        }
    }
}