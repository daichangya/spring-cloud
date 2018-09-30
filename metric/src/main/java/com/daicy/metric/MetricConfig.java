package com.daicy.metric;

import com.codahale.metrics.*;
import com.codahale.metrics.servlet.InstrumentedFilter;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.concurrent.TimeUnit;

@Configuration
public class MetricConfig {

    private MetricRegistry metricRegistry = new MetricRegistry();

    @Bean
    public ServletContextInitializer servletContextInitializer() {

        return new ServletContextInitializer() {

            @Override
            public void onStartup(ServletContext servletContext) throws ServletException {
                servletContext.setAttribute(InstrumentedFilter.REGISTRY_ATTRIBUTE,metricRegistry);
            }
        };
    }

    @Bean
    public MetricRegistry metrics() {
        return metricRegistry;
    }

    @Bean
    public FilterRegistrationBean instrumentedFilter() {
        FilterRegistrationBean instrumentedFilter = new FilterRegistrationBean();
        instrumentedFilter.addUrlPatterns("/*");
        instrumentedFilter.setFilter(new InstrumentedFilter());
        return instrumentedFilter;
    }

    /**
     * Reporter 数据的展现位置
     *
     * @param metrics
     * @return
     */
    @Bean
    public ConsoleReporter consoleReporter(MetricRegistry metrics) {
        return ConsoleReporter.forRegistry(metrics)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();
    }


//    @Bean(name = "influxdbReporter")
//    public ScheduledReporter influxdbReporter(MetricRegistry metrics) throws Exception {
//        return InfluxdbReporter.forRegistry(metrics)
//				.protocol(InfluxdbProtocols.http())
//                .convertRatesTo(TimeUnit.SECONDS)
//                .convertDurationsTo(TimeUnit.MILLISECONDS)
//                .filter(MetricFilter.ALL)
//                .skipIdleMetrics(false)
//                .build();
//    }


    @Bean
    public Slf4jReporter slf4jReporter(MetricRegistry metrics) {
        return Slf4jReporter.forRegistry(metrics)
                .outputTo(LoggerFactory.getLogger("demo.metrics"))
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();
    }

    @Bean
    public JmxReporter jmxReporter(MetricRegistry metrics) {
        return JmxReporter.forRegistry(metrics).build();
    }


//    /**
//     * TPS 计算器
//     *
//     * @param metrics
//     * @return
//     */
//    @Bean
//    public Meter requestMeter(MetricRegistry metrics) {
//        return metrics.meter("requestAAA");
//    }
//
//    /**
//     * 直方图
//     *
//     * @param metrics
//     * @return
//     */
//    @Bean
//    public Histogram responseSizes(MetricRegistry metrics) {
//        return metrics.histogram("responsesizes");
//    }
//
//    /**
//     * 计数器
//     *
//     * @param metrics
//     * @return
//     */
//    @Bean
//    public Counter pendingJobs(MetricRegistry metrics) {
//        return metrics.counter("requestCount");
//    }
//
//    /**
//     * 计时器
//     *
//     * @param metrics
//     * @return
//     */
//    @Bean
//    public Timer responses(MetricRegistry metrics) {
//        return metrics.timer("executeTime");
//    }

}
