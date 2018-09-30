package com.daicy.configclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@Slf4j
public class TestController {

    @Autowired
    private CounterService counterService;
    @Autowired
    private GaugeService gaugeService;


    @Value("${daicy.lucky-word}")
    private String luckyWord;

//    @Resource
//    private Utils utils;


    @RequestMapping("/config")
    public String config(@RequestParam("message") String message, HttpServletResponse response) {
//        System.out.println(utils.getAppList());
        System.out.println(Utils.getUtils().getAppList());

        long startNanoTime = System.nanoTime();
        counterService.increment("daicy.config.count");
        try {
            String result = "config" + luckyWord;
            return result;
        } finally {
            gaugeService.submit("daicy.config.time", System.nanoTime() - startNanoTime + 8);
        }
    }
}
