package com.sunnywr.controller;

import com.sunnywr.properties.PersonProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/hello", method = RequestMethod.GET)
public class HelloController {

//    @Value("${name}")
//    private String name;
//
//    @Value("${age}")
//    private Integer age;
//
//    @Value("${content}")
//    private String content;

    @Autowired
    private PersonProperties personProperties;

//    @RequestMapping(value = "/say/{id}", method = RequestMethod.GET)
//    @RequestMapping(value = "/say", method = RequestMethod.GET)
    @GetMapping("/say")
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
//        return "Hello Spring Boot!";
//        return personProperties.getName();
        return "id: " + id;
    }
}
