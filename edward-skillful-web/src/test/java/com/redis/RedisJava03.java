package com.redis;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * exec和有效期
 * Created by weideliang on 2016/9/26.
 */
public class RedisJava03 {
    private static RedisTemplate redisTemplate;
    /**
     *
     * @param key
     * @param value
     * @param activeTime 生存时间 超时自动删除
     * @return
     */
 /*   public Boolean set(final byte[] key,final byte[] value,final long activeTime){
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                Boolean expire = true;
                connection.set(key,value);
                if(activeTime > 0){
                    expire = connection.expire(key, activeTime);
                }
                return expire;
            }
        });
    }*/
}