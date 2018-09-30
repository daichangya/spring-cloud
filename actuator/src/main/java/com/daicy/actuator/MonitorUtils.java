package com.daicy.actuator;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.spectator.api.Registry;
import com.netflix.spectator.api.Timer;

@Component
public class MonitorUtils {
    @Autowired
    private Registry registry;

    private Timer timer;

    @PostConstruct
    public void init() {
        timer = registry.timer("timerName", "tagKey1", "tagValue1");
//// execute an operation and time it at the same time
//        T result = timer.record(() -> fooReturnsT());

// alternatively, if you must manually record the time
    }

    public void recordOne(long startNanoTime) {
        timer.record(System.nanoTime() - startNanoTime, TimeUnit.NANOSECONDS);
    }
}
