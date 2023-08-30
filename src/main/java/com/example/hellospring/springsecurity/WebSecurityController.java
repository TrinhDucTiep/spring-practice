package com.example.hellospring.springsecurity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebSecurityController {

    @GetMapping(value = {"/", "/home"})
    public String homepage() {
        return "home";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
