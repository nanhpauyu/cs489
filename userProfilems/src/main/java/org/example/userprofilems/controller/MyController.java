package org.example.userprofilems.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class MyController {

//    @GetMapping
//    public String home() {
//        return "Hello World";
//    }

    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello World");
    }



//    @GetMapping("/{name}")
//    public String sayHello(@PathVariable String name) {
//        return "Hello " + name;
//    }
}
