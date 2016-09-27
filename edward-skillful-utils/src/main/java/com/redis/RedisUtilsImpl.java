package com.redis;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Edward on 2016/9/26.
 */
public class RedisUtilsImpl implements RedisUtils{
    //默认有效时间为30分钟
    public static final Long defaultLiveTime = 30 * 60l;
    private RedisTemplate redisTemplate;

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    //String和对象
    public void set(String key,Object value,Long liveTime){
        this.delete(key);
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key,value);
        this.setLiveTime(key, liveTime);
    }

    /**
     * 设置生存时间
     * @param key
     * @param liveTime
     */
    private void setLiveTime(String key, Long liveTime) {
        if(null == liveTime){
            redisTemplate.expire(key,defaultLiveTime, TimeUnit.SECONDS);
        }else if(liveTime > 0l){
            redisTemplate.expire(key,liveTime, TimeUnit.SECONDS);
        }
    }

    public Object get(String key){
        return redisTemplate.opsForValue().get(key);
    }

    //list
    public void setList(String key, List<?> list,Long liveTime){
        //若不删除,就是追加
        this.delete(key);
        ListOperations listOperations = redisTemplate.opsForList();
        for (Object o : list) {
            listOperations.leftPush(key,o);
        }
        this.setLiveTime(key,liveTime);
    }

    public Object getList(String key){
        return redisTemplate.opsForList().range(key,0,-1);
    }

    //set
    public void setSet(String key, Set<?> set,Long liveTime){
        this.delete(key);
        SetOperations setOperations = redisTemplate.opsForSet();
        for (Object o : set) {
            setOperations.add(key,o);
        }
        this.setLiveTime(key,liveTime);
    }

    public Object getSet(String key){
        return redisTemplate.opsForSet().members(key);
    }

    //map
    public void setMap(String key, Map<String,?> map,Long liveTime){
        this.delete(key);
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.putAll(key,map);
        this.setLiveTime(key,liveTime);
    }

    @Override
    public void transfaction(final String key, final String value) {
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

    @Override
    public String flushDB() {
        return (String)redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.flushDb();
                return "ok";
            }
        });
    }

    public Object getMap(String key){
        return redisTemplate.opsForHash().entries(key);
    }

    public void delete(String key){
        if(redisTemplate.hasKey(key)){
            redisTemplate.delete(key);
        }
    }

    @Override
    public Boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }
}
