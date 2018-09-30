package com.daicy.feign;

import com.netflix.hystrix.HystrixCommand;
import feign.Contract;
import feign.Param;
import feign.Request;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.support.FallbackCommand;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@FeignClient(value = "messageService",url = "http://localhost:8011/",
configuration = TestFeignServiceConfiguration.class,fallback = TestFeignServiceFallback.class)
public interface TestFeignService {

    @RequestLine("GET /al?message={message}")
    HystrixCommand<SmsSendResult> alSendCode(@Param("message") String message);

    default SmsSendResult sendAl(String message) {
        return alSendCode(message).execute();
    }

    @RequestLine("GET /tx?message={message}")
    String txSendCode(@Param("message") String message);
}

class TestFeignServiceFallback implements TestFeignService {
    @Override
    public HystrixCommand<SmsSendResult> alSendCode(String message) {
        return new FallbackCommand<>(SmsSendResult.TIMEOUT);
    }

    @Override
    public String txSendCode(String message) {
        return "ttttttt";
    }
}

@Configuration
class TestFeignServiceConfiguration {

    @Bean
    public TestFeignServiceFallback TestFeignServiceFallback() {
        return new TestFeignServiceFallback();
    }

    @Bean
    public Contract contract() {
        return new Contract.Default();
    }

    @Bean
    public Request.Options requestOptions() {
        return new Request.Options(2000, 2000);
    }
}
