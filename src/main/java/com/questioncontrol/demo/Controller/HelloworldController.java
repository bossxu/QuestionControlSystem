package com.questioncontrol.demo.Controller;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HelloworldController {

    @RequestMapping("/api/hello")
    public String helloworld()
    {
        return "hello world";
    }
}
