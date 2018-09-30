package com.daicy.sleuth;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@Slf4j
public class TestController {

//    private static final Log log = LogFactory.getLog(TestController.class);


    @Autowired
    private CounterService counterService;
    @Autowired
    private GaugeService gaugeService;


    private AtomicInteger atomicIntegerAl = new AtomicInteger(0);

    private AtomicInteger atomicIntegerTx = new AtomicInteger(0);

    @Resource
    private RestTemplate restTemplate;


    @RequestMapping("/al")
    public String alSengdCode(@RequestParam("message") String message, HttpServletResponse response) {
        long startTime = System.currentTimeMillis();
        counterService.increment("daicy.al.count");
        try {
            Thread.sleep(3000);
            String result = "albb" + message;
            log.info(result + atomicIntegerAl.incrementAndGet());
            return result;
        } catch (Exception e) {
            log.error("dddddddddddd",e);
        }finally {
            gaugeService.submit("daicy.al.time", System.currentTimeMillis() - startTime + 8);
        }
        return null;
    }

    @RequestMapping("/tx")
    public String txSengdCode(@RequestParam("message") String message, HttpServletResponse response) {
        long startNanoTime = System.nanoTime();
        counterService.increment("daicy.tx.count");
        try {
            log.info("tx" + atomicIntegerTx.incrementAndGet());
            return restTemplate.getForObject("http://localhost:8011/tx?message={message}",String.class,message);
        } finally {
            gaugeService.submit("daicy.tx.time", System.nanoTime() - startNanoTime + 8);
        }
    }

    @RequestMapping("/config")
    public String config(@RequestParam("message") String message, HttpServletResponse response) {
        long startNanoTime = System.nanoTime();
        counterService.increment("daicy.config.count");
        try {
            String result = "config" ;
            log.info(result + atomicIntegerTx.incrementAndGet());
            return result;
        } finally {
            gaugeService.submit("daicy.config.time", System.nanoTime() - startNanoTime + 8);
        }
    }

    @Bean
    public AlwaysSampler defaultSampler(){
        return new AlwaysSampler();
    }
}
