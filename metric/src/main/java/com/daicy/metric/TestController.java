package com.daicy.metric;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TestController {


    @Autowired
    private CounterService counterService;

    @Autowired
    private GaugeService gaugeService;


    @RequestMapping("/hello")
    @ResponseBody
    public String helloWorld() {

//        counterService.increment("meter.helloCount");
        long startTime = System.currentTimeMillis();
        try {
            return "Hello World";
        } finally {
//            gaugeService.submit("timer.helloTime",System.currentTimeMillis() - startTime);
        }
    }

    @RequestMapping("/hello2")
    @ResponseBody
    public String helloWorld2() {

        counterService.increment("meter.helloCount2");
        long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(200);
            return "Hello World";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        } finally {
            gaugeService.submit("timer.helloTime2",System.currentTimeMillis() - startTime);
        }
    }
}
