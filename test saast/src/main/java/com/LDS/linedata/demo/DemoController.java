package com.LDS.linedata.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/demo-Controller")
public class DemoController {
    @GetMapping
    public ResponseEntity<String> sayHello()
    {
        return ResponseEntity.ok("behi hak tekhdem sahit ");

    }
   /* @GetMapping
    public List<String> sayHi()
    {
        // return ResponseEntity.ok("Hello from secured endpoint");
        return List.of("hi","hi","hello");
    }*/
}
