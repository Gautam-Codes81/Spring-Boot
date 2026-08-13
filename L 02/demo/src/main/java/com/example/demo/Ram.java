package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ram {
    @GetMapping("/hello")
    public String ram(){
        return "<h1>Hello ritik gautam</h1>";
    }

    @GetMapping("/Bye")
    public String greetBye(){
        return "<h1>Bye gautam ritik</h1>";
    }
}
