package com.example.hellospring.firstweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
    @GetMapping("/")
    public String index() {
        return "index"; // nghĩa là trả về trang index.html
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/hello")
    public String hello(
            @RequestParam(name = "name", required = false, defaultValue = "") String name, // này lấy từ request param
            Model model // đây là object được spring đính kèm trong mỗi response trả về cho client
    ) {
        model.addAttribute("name", name); // gắn vào model giá trị name nhận được
        return "hello";
    }
}
