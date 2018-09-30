package com.daicy.sample;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class TestController {

//    private static final Log log = LogFactory.getLog(TestController.class);



    @RequestMapping("/al")
    public String alSengdCode(@RequestParam("message") String message, HttpServletResponse response) {
            String result = "albb" + message;
            return result;
    }
}
