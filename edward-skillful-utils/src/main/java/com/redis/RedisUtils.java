package com.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * redis 接口
 * 优秀博客:http://jingpin.jikexueyuan.com/article/56643.html
 * redis命令 http://redisdoc.com/
 * Created by Edward on 2016/9/26.
 */
public interface RedisUtils {
    //String和object
    public void set(String key,Object value,Long liveTime);
    public Object get(String key);
    //list
    public void setList(String key, List<?> list, Long liveTime);
    public Object getList(String key);
    //set
    public void setSet(String key, Set<?> set, Long liveTime);
    public Object getSet(String key);
    //map
    public void setMap(String key, Map<String,?> map, Long liveTime);
    public Object getMap(String key);

    //删除
    public void delete(String key);
    //清空当前数据库中的所有 key
    public String flushDB();
    //存在
    public Boolean exists(String key);

    //事务
    public void transfaction(final String key, final String value);
}
