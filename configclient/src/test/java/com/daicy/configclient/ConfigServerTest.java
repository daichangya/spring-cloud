package com.daicy.configclient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigServerTest {

    @Value("${daicy.lucky-word}")
    String luckyWord;
    @Test
    public void test(){
        System.out.println(luckyWord);
    }
}
