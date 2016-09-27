package com.redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * exec和有效期
 * Created by weideliang on 2016/9/26.
 */
public class RedisJava04 {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("redisTest.xml");
        RedisUtils redisUtils = ctx.getBean("redisUtils", RedisUtils.class);
        redisUtils.deletePattern("1");
        redisUtils.deletePattern("1");
    }
}