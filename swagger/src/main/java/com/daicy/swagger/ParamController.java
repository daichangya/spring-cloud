package com.daicy.swagger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.atomic.AtomicInteger;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import static org.springframework.util.MimeTypeUtils.APPLICATION_XML_VALUE;

@Controller
@Slf4j
@Api(value = "ParamController", description = "接口")
public class ParamController {

    private ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping(value = "/test",method={RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String test(@RequestParam("message") String message, HttpServletResponse response) {
        String result = "test" + message;
        return result;
    }

    @ApiOperation(value="tx", notes="tx接口" ,httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType ="query" ,name = "message", value = "消息",  required = true ,dataType = "string")
    })
    @RequestMapping(value = "/tx",method={RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String txSengdCode(@RequestParam("message") String message, HttpServletResponse response) {
        String result = "txqq" + message;
        return result;
    }

    @ApiOperation(value="json", notes="json接口" )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType ="query" ,name = "message", value = "消息",  required = true ,dataType = "string")
    })
    @RequestMapping("/json")
    @ResponseBody
    public String json(@RequestParam("message") String message, HttpServletResponse response) {
        String result = "json" + message;
        try {
            return objectMapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
