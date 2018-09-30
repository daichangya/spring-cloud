package com.daicy.actuator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
//@ContextConfiguration(locations = "classpath:spring/spring-redis.xml")
public class CacheServiceTest {

    @Resource
    private CacheService cacheService;

    @Test
    public void getString() {
        for (int i = 0; i < 10; i++) {
            System.out.println(cacheService.getString("dai" + i));
        }
    }
}