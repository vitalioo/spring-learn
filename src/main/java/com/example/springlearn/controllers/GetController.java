package com.example.springlearn.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetController {
    @GetMapping("/root")
    public String root() {
        return "root";
    }
}
