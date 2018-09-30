package com.daicy.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    private RestTemplate restTemplate;


    private AtomicInteger atomicIntegerAl = new AtomicInteger(0);

    private AtomicInteger atomicIntegerTx = new AtomicInteger(0);

    @HystrixCommand(fallbackMethod = "alSendCodeFallback")
    @RequestMapping("/al")
    public String alSengdCode(@RequestParam("message") String message) {
        long startTime = System.currentTimeMillis();
        try {
            counterService.increment("daicy.al.count");
            String result = restTemplate.getForObject("http://localhost:8011/al?message=xxx",String.class);
            log.info(result + atomicIntegerAl.incrementAndGet());
            return result;
        } finally {
            gaugeService.submit("daicy.al.time", System.currentTimeMillis() - startTime + 8);
        }
    }

    @HystrixCommand(threadPoolKey = "tx",fallbackMethod = "txSendCodeFallback")
    @RequestMapping("/tx")
    public String txSengdCode(@RequestParam("message") String message) {
        long startTime = System.currentTimeMillis();
        try {
            counterService.increment("daicy.tx.count");
            String result = restTemplate.getForObject("http://localhost:8011/tx?message=xxx",String.class);
            log.info(result + atomicIntegerTx.incrementAndGet());
            return result;
        } finally {
            gaugeService.submit("daicy.tx.time", System.currentTimeMillis() - startTime + 8);
        }
    }

    public String alSendCodeFallback(String message, Throwable e) {
        String result = "aaaaaaa";
        log.info(result + atomicIntegerAl.incrementAndGet());
//        log.error("alSendCodeFallback",e);
        return result;
    }

    public String txSendCodeFallback(String message, Throwable e) {
        String result = "ttttttt";
        log.info(result + atomicIntegerTx.incrementAndGet());
        log.error("txSendCodeFallback",e);
        return result;
    }

}
