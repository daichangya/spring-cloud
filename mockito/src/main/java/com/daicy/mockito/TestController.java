package com.daicy.mockito;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TestController {

    @Autowired
    private CounterService counterService;
    @Autowired
    private GaugeService gaugeService;


    private AtomicInteger atomicIntegerAl = new AtomicInteger(0);

    private AtomicInteger atomicIntegerTx = new AtomicInteger(0);


    @RequestMapping("/al")
    public SmsSendResult alSengdCode(@RequestParam("message") String message, HttpServletResponse response) {
        long startTime = System.currentTimeMillis();
        counterService.increment("daicy.al.count");
        try {
//            Thread.sleep(3000);
            String result = "albb" + message;
            log.info(result + atomicIntegerAl.incrementAndGet());
            return SmsSendResult.SUCCESS;
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
            String result = "txqq" + message;
            log.info(result + atomicIntegerTx.incrementAndGet());
            return result;
        } finally {
            gaugeService.submit("daicy.tx.time", System.nanoTime() - startNanoTime + 8);
        }
    }
}
