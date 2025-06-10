package com.msvc.spring.fml_web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {

    @GetMapping("/redirect")
    public String home() {
        return "redirect:/path/details";
    }
    @GetMapping({"/forward"})
    public String path() {
        return "forward:/path/details";
    }

}
