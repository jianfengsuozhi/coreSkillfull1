package com.redis;

import com.google.common.collect.Maps;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 若key相同,则为修改
 * 对象序列化前提: implements Serializable 加密和解密
 *
 * Created by weideliang on 2016/9/26.
 */
public class RedisJava02 {
    private static RedisTemplate redisTemplate;

    public static void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisJava02.redisTemplate = redisTemplate;
    }

    //String和对象
    public void set(String key,Object value){
        this.delete(key);
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key,value);
    }

    public Object get(String key){
        return redisTemplate.opsForValue().get(key);
    }

    //list
    public void setList(String key, List<?> list){
        //若不删除,就是追加
        this.delete(key);
        ListOperations listOperations = redisTemplate.opsForList();
        for (Object o : list) {
            listOperations.leftPush(key,o);
        }
    }

    public Object getList(String key){
        return redisTemplate.opsForList().range(key,0,-1);
    }

    //set
    public void setSet(String key, Set<?> set){
        this.delete(key);
        SetOperations setOperations = redisTemplate.opsForSet();
        for (Object o : set) {
            setOperations.add(key,o);
        }
    }

    public Object getSet(String key){
        return redisTemplate.opsForSet().members(key);
    }

    //map
    public void setMap(String key, Map<String,?> map){
        this.delete(key);
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.putAll(key,map);
    }

    public Object getMap(String key){
        return redisTemplate.opsForHash().entries(key);
    }

    public void delete(String key){
        if(redisTemplate.hasKey(key)){
            redisTemplate.delete(key);
        }
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("redis.xml");
        redisTemplate = (RedisTemplate)ctx.getBean("redisTemplate");

        RedisJava02 redisJava02 = new RedisJava02();
        //测试String和对象
     /*   redisJava02.set("name","魏德亮");
        System.out.println(redisJava02.get("name"));*/

/*        redisJava02.set("user",new User("魏德亮",new Date()));
        User user = (User) redisJava02.get("user");
        System.out.println(user);*/

        //测试list
/*        ArrayList<String> list = Lists.newArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        redisJava02.setList("list1",list);
        List<String> list1 = (List<String>) redisJava02.getList("list1");
        for (String s : list1) {
            System.out.println(s);
        }*/

        //测试set
/*        HashSet<String> set = Sets.newHashSet();
        set.add("a");
        set.add("b");
        set.add("c");
        redisJava02.setSet("set",set);
        HashSet<String> set1 = (HashSet<String>)redisJava02.getSet("set");*/

        HashMap<String, Object> map = Maps.newHashMap();
        map.put("name","魏德亮");
        map.put("age",23);
//        redisJava02.setMap("map",map);
        HashMap<String, Object> map1 = (HashMap<String, Object>) redisJava02.getMap("map");
        System.out.println(map1.get("name"));
        System.out.println(map1.get("age"));

    }

}