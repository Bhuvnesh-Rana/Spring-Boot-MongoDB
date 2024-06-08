package com.mongo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.DAO.EmployeeDAO;
import com.mongo.Service.EmployeeService;

@RestController
@RequestMapping("/mongo")
public class MongoController {


    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping("/")
    public String show(){
        return "Running";
    }

    @PostMapping("/employee")
    public String addEmp(@RequestBody EmployeeDAO employeeDAO){
        return employeeService.addUser(employeeDAO);
    }

    @GetMapping("/employee")
    public List<EmployeeDAO> show1(){
        return employeeService.getAllEmployee();
    }
}
