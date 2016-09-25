package com.web.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.*;

import java.util.*;

/**
 * Created by weideliang on 2016/9/25.
 */
public class TestSringDataJedis {
    static RedisTemplate redisTemplate;


    public void set(String key,Object value){
        //ValueOperations 理解成Map<Object,Object>


//        redisTemplate.opsForValue().set("redis-key","I'm test spring-data-redis");
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key,value);


        //BoundValueOperations的理解对保存的值做一些细微的操作
//        BoundValueOperations boundValueOperations = redisTemplate.boundValueOps(key);
    }
    public Object get(String key){
        return redisTemplate.opsForValue().get(key);
    }
    public void setList(String key ,List<?> value){
        //ListOperations可以理解为List<Object>
        ListOperations listOperations= redisTemplate.opsForList();
        listOperations.leftPush(key, value);
//                .leftPushAll(value);
    }
    public Object getList(String key){
        //ListOperations可以理解为List<Object>
        return redisTemplate.opsForList().leftPop("test-list");
    }
    public void setSet(String key ,Set<?> value){
        SetOperations setOperations= redisTemplate.opsForSet();
        setOperations.add(key, value);
    }
    public Object getSet(String key){
        return redisTemplate.opsForSet().members(key);
    }


    public void setHash(String key ,Map<String,?> value){
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.putAll(key,value);
    }
    public Object getHash(String key){
        return redisTemplate.opsForHash().entries(key);
    }


    public void delete(String key){
        redisTemplate.delete(key);
    }
//    public void clearAll(){
//        redisTemplate.multi();
//    }


    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("redis.xml");
        redisTemplate = (RedisTemplate)ctx.getBean("redisTemplate");
        TestSringDataJedis jedis = new TestSringDataJedis();
        //String
//        jedis.set("test-string", "good-中国抗战胜利");
        System.out.println("test-string = " + jedis.get("test-string"));
        //POJO
        User user =new User();
        user.setName("邓洋");

        jedis.set("test-user", user);
        System.out.println("test-user = " + jedis.get("test-user"));
        System.out.println("test-user:name = " + ((User)jedis.get("test-user")).getName());
        //List
        List<String> list = new ArrayList<String>();
        list.add("张三");
        list.add("李四");
        list.add("麻子");
        String key_list = "test-list";
        jedis.setList(key_list, list);


        List<String> test_list = (List<String>)jedis.getList(key_list);
        for (int i = 0; i < test_list.size(); i++) {
            System.out.println(i + " = " + test_list.get(i));
        }
        //Map
        String key_map = "test-map";
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("map1","map-张三");
        map.put("map2","map-李四");
        map.put("map3", "map-麻子");
        jedis.setHash(key_map, map);
        Map<String,Object> getMap = (Map<String,Object>)jedis.getHash(key_map);
        return;
    }
}