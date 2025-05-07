package com.ecommerce.flipkart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testMail(){
        redisTemplate.opsForValue().set("email","gmail@email.com");
        Object salary=redisTemplate.opsForValue().get("salary");

    }
}
