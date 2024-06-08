package com.mongo.Service;

import com.mongo.DAO.EmployeeDAO;

public interface EmployeeService {

    String addUser(EmployeeDAO dao);
    String updateEmployee(EmployeeDAO employeeDAO, int id);
    // List<EmployeeDAO> getAllEmployee();
    EmployeeDAO getEmployeeById(int id);
    

}
