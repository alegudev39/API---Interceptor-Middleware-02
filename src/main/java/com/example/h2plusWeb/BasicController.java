package com.example.h2plusWeb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @GetMapping("/")
    public String welcome() {
        return "Welcome to the Month API!";
    }
}