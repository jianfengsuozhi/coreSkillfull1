package com.redis;

import java.util.Date;

/**
 * Created by weideliang on 2016/10/29.
 */
public interface RedisUtils02 {
    /**
     * 增加或修改
     * 加入缓存设置缓存时间:
     * 当有两个相同的key时,取最新
     * @param key
     * @param value
     * @param expireDate 可选
     */
    void set(String key, Object value, Date expireDate);

    /**
     * 获取
     * @param key
     * @return
     */
    Object get(String key);
}
