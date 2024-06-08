package com.mongo.Service;

import com.mongo.DAO.EmployeeDAO;
import java.util.List;

public interface EmployeeService {

    String addUser(EmployeeDAO dao);
    String updateEmployee(EmployeeDAO employeeDAO, int id);
    List<EmployeeDAO> getAllEmployee();
    EmployeeDAO getEmployeeById(int id);
    String deleteEmployee(int id);
    
    

}
