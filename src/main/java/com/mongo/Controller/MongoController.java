package com.mongo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.DAO.EmployeeDAO;
import com.mongo.Repository.EmployeeRepository;
import com.mongo.Service.EmployeeService;

@RestController
public class MongoController {


    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @GetMapping("/")
    public String show(){
        return "Running";
    }

    @PostMapping("/add")
    public String addEmp(@RequestBody EmployeeDAO employeeDAO){
        return employeeService.addUser(employeeDAO);
    }

    @GetMapping("/show")
    public ResponseEntity<?> show1(){
        return ResponseEntity.ok(this.employeeRepository.findAll());
    }
}
