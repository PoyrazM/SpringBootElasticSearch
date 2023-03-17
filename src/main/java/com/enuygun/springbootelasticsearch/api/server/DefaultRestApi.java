package com.enuygun.springbootelasticsearch.api.server;

import io.netty.util.internal.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
@RequestMapping(value = "/api")
public class DefaultRestApi {

    @GetMapping(value = "/welcome")
    public String welcome() {
        System.out.println(StringUtils.join("Hello", " this is" , " Spring Boot" , " REST API"));
        return "Welcome to the Spring Boot";
    }

    @GetMapping(value = "/time")
    public String time() {
        return LocalTime.now().toString();
    }


}
