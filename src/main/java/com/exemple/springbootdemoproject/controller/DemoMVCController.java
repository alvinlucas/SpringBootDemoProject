package com.exemple.springbootdemoproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoMVCController {

    @GetMapping("/message")
    public String displayMessage() {
        return "Hello Ynov";
    }
}
