package com.daicy.eureka;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @RequestMapping("/local/hello")
    public String hello() {
        return "Hello World Client";
    }

}