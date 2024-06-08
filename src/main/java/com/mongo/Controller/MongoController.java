package com.mongo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public List<EmployeeDAO> getAllEmployees(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employee/{id}")
    public EmployeeDAO getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/employee/{id}")
    public String updateEmployee(@RequestBody EmployeeDAO employeeDAO, @PathVariable int id){
        return employeeService.updateEmployee(employeeDAO, id);
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable int id){
        return employeeService.deleteEmployee(id);
    }
}
