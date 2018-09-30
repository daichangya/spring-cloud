package com.daicy.actuator;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class CacheService {

    @Cacheable(value = "myCache")
    public String getString(String key){
        return "String"+key;
    }
}
