package com.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * Created by weideliang on 2016/10/29.
 */
@Service
public class RedisUtils02Impl implements RedisUtils02 {
    final Logger logger = LoggerFactory.getLogger(RedisUtils02Impl.class);
    private static final long DEFAULT_EXPIRY = 60 * 1000 * 30;
    private RedisTemplate<byte[], byte[]> redisTemplate;
    private String name;
    public void setRedisTemplate(RedisTemplate<byte[], byte[]> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void set(String key, Object value, Date expireDate) {
        if(null == expireDate){
            expireDate = new Date(new Date().getTime() + DEFAULT_EXPIRY);
        }
        this.save(key,value,expireDate);
    }

    @Override
    public void delete(String key) {
        this.set(key,null,null);
    }

    @Override
    public Object get(String key) {
        return this.find(key);
    }



    /**
     * 通过key找到值
     * @param key
     */
    private Object find(final String key) {
        if(null == key){
            logger.warn("缓存key为null");
            return null;
        }
        try {
            return redisTemplate.execute(new RedisCallback<Object>() {
                @Override
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    byte[] keyBytes = key.getBytes(Charset.forName("utf-8"));
                    byte[] valueBytes = connection.get(keyBytes);
                    if(null == valueBytes){
                        return null;
                    }else {
                        return redisTemplate.getValueSerializer().deserialize(valueBytes);
                    }
                }
            });
        }catch (Exception e){
            logger.error("redis缓存:"+e.getMessage());
            return null;
        }
    }

    /**
     *
     * @param key
     * @param value 可选
     * @param expireDate
     */
    private void save(final String key, final Object value, final Date expireDate) {
        if(null == key){
            logger.warn("缓存key为null");
            return;
        }

        if(null == value){
            logger.warn("有效期为null");
            return;
        }
        try{
            redisTemplate.execute(new RedisCallback<Object>() {
                @Override
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    byte[] keyBytes = key.getBytes(Charset.forName("utf-8"));

                    if(null == value){//删除
                        connection.del(keyBytes);
                    }else {
                        RedisSerializer valueSerializer = redisTemplate.getValueSerializer();
                        connection.set(keyBytes,valueSerializer.serialize(value));
                        Boolean rs = connection.expire(keyBytes, expireDate.getTime() / 1000);
                        if(!rs){
                            logger.warn(key+"缓存时间设置失败");
                        }
                        return null;
                    }
                    return null;
                }
            });
        }catch (Exception e){
            logger.error("redis缓存异常"+e.getMessage());
            return;
        }
    }
}
