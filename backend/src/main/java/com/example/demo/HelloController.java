package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@CrossOrigin
public class HelloController {
    @GetMapping("/api/hello")
    public Map<String, String> hello() {
        return Map.of("message", "Hello from backend!");
    }

    @GetMapping("/")
    public Map<String, String> root() {
        return Map.of("message", "Backend is running!");
    }
}
