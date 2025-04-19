package com.oxyl.coursepfback.controller.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class helloController {

    @ResponseBody
    @GetMapping
    public String hello() {
        return "Hello depuis Spring MVC !";

    }
}
