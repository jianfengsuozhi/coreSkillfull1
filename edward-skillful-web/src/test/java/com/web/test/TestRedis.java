package com.web.test;

/**
 * Created by weideliang on 2016/9/25.
 */
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:skillful-servlet.xml")
public class TestRedis {
    @Resource
    private RedisTemplate<String, String> template; // inject the template as ListOperations




}