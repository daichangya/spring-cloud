package com.daicy.feign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@Slf4j
public class TestController {

    @Autowired
    private CounterService counterService;
    @Autowired
    private GaugeService gaugeService;
    @Autowired
    private TestFeignService testFeignService;
    @Autowired
    private RestTemplate restTemplate;

    private AtomicInteger atomicIntegerAl = new AtomicInteger(0);

    private AtomicInteger atomicIntegerAlHttp = new AtomicInteger(0);

    private AtomicInteger atomicIntegerTx = new AtomicInteger(0);

    @RequestMapping("/alHttp")
    public String alHttpSengdCode(@RequestParam("message") String message, HttpServletResponse response) {
        long startTime = System.currentTimeMillis();
        try {
            counterService.increment("daicy.alHttp.count");
            String result = restTemplate.getForObject("http://localhost:8011/al?message=xxx",String.class);
            log.info(result + atomicIntegerAlHttp.incrementAndGet());
            return result;
        } finally {
            gaugeService.submit("daicy.alHttp.time", System.currentTimeMillis() - startTime + 8);
        }
    }

    @RequestMapping("/al")
    public String alSengdCode(@RequestParam("message") String message, HttpServletResponse response) {
        long startTime = System.currentTimeMillis();
        try {
            counterService.increment("daicy.al.count");
            String result =  testFeignService.sendAl(message).toString();
            log.info(result + atomicIntegerAl.incrementAndGet());
            return result;
        } finally {
            gaugeService.submit("daicy.al.time", System.currentTimeMillis() - startTime + 8);
        }
    }

    @RequestMapping("/tx")
    public String txSengdCode(@RequestParam("message") String message, HttpServletResponse response) {
        long startTime = System.currentTimeMillis();
        try {
            counterService.increment("daicy.tx.count");
            String result =  testFeignService.txSendCode(message);
            log.info(result + atomicIntegerTx.incrementAndGet());
            return result;
        } finally {
            gaugeService.submit("daicy.tx.time", System.currentTimeMillis() - startTime + 8);
        }
    }

}
