package com.mongo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.Entity.Employee;
import com.mongo.Repository.EmployeeRepository;

@RestController
public class MongoController {


    @Autowired
    private EmployeeRepository empRepo;
    
    @GetMapping("/")
    public String show(){
        return "Running";
    }

    @PostMapping("/add")
    public String addEmp(@RequestBody Employee emp){
        empRepo.save(emp);
        return "Saved";
    }

    @GetMapping("/show")
    public ResponseEntity<?> show1(){
        return ResponseEntity.ok(this.empRepo.findAll());
    }
}
