package com.example.h2plusWeb;

import com.example.h2plusWeb.Month;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonthController {

    @GetMapping("/months")
    public Month getMonth(@RequestAttribute("month") Month month) {
        return month;
    }
}
