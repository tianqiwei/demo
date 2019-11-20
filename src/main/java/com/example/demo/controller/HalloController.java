package com.example.demo.controller;

import com.example.demo.pojo.WTQProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HalloController {
    @Value("${wtq.name}")
    private String name;

    @Autowired
    private WTQProperties wtqProperties;


    @RequestMapping(value = "/wtq", method = RequestMethod.GET)
    public WTQProperties getWTQInfo(){
        //return "wtq.name="+name;
        return wtqProperties;
    }

    @RequestMapping(value = "/Hallo")
    public String say() { return "Hallo Java";};
}
