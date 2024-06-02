package com.mongo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MongoController {
    
    @GetMapping("/")
    public String show(){
        return "Running";
    }
}
