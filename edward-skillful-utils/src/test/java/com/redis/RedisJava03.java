package com.redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.UnsupportedEncodingException;

/**
 * exec和有效期
 * Created by weideliang on 2016/9/26.
 */
public class RedisJava03 {
    public static final String redisCode = "utf-8";
    //默认单位是秒
    public static final Long time = 60 * 60l;
    private static RedisTemplate redisTemplate;
    /**
     *
     * @param key
     * @param value
     * @param liveTime 生存时间 超时自动删除
     * @return
     */
    public Boolean set(final byte[] key, final byte[] value, final long liveTime){
         return (Boolean) redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                Boolean expire = true;
                connection.set(key,value);
                if(liveTime > 0){
                    connection.expire(key, liveTime);
                }
                return expire;
            }
        });
    }

    public Boolean set(String key, String value, Long liveTime){
        return this.set(key.getBytes(),value.getBytes(),liveTime);
    }

    public Boolean set(byte[] key,byte[] value){
        return this.set(key,value,0l);
    }

    public Boolean set(String key,String value){
        return this.set(key,value,0l);
    }

    /**
     * 获取
     * @param key
     * @return
     */
    public String get(final String key){
        return (String) redisTemplate.execute(new RedisCallback<String>() {
            public String doInRedis(RedisConnection redisConnection) throws DataAccessException {
                try {
                    return new String(redisConnection.get(key.getBytes()),redisCode);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                return "";
            }
        });
    }

    /**
     * 清空当前数据库中的所有 key
     * @return
     */
    public String flushDB(){
        return (String)redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.flushDb();
                return "ok";
            }
        });
    }

    /**
     * 事务
     * @param key
     * @param value
     */
    public void transfaction(final String key, final String value){
        redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.multi();
                redisConnection.set(key.getBytes(),value.getBytes());//没有设有效期 永久存在
                redisConnection.exec();
                return null;
            }
        });
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("redisTest.xml");
        redisTemplate = (RedisTemplate)ctx.getBean("redisTemplate");

        RedisJava03 redisJava03 = new RedisJava03();
/*        Boolean set = redisJava03.set("name", "魏德亮", time);
        String name = redisJava03.get("name");
        System.out.println(name);*/

//        redisJava03.flushDB();

//        redisJava03.transfaction("name1","魏德亮");

    }
}