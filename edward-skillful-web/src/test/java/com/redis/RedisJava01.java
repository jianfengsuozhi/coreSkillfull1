package com.redis;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * 若key相同,则为修改
 * Created by weideliang on 2016/9/26.
 */
public class RedisJava01 {
    public static void main(String[] args) {
        //连接服务器
        Jedis jedis = new Jedis("localhost",6379);
//        System.out.println("查看客户端和服务端连接是否正常"+jedis.ping());

        //String类型
//        jedis.set("name","tom");//修改：若第一次 name:"tom" 第二次为name:"pin" 则为“pin”
//        System.out.println("key:name的值"+jedis.get("name"));

        //列表
/*        jedis.lpush("list","str1");
        jedis.lpush("list","str2");
        jedis.lpush("list","str3");
        List<String> lrange = jedis.lrange("list", 0, 2);//取值 注 [,] str1 str2 str3
        for (String str : lrange) {
            System.out.println("list的包含值:"+str);
        }*/

        //keys
        Set<String> keys = jedis.keys("*"); //所有key
        for (String key : keys) {
            System.out.println("key:"+key);
        }
    }
}