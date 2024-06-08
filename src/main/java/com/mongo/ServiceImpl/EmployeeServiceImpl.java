package com.mongo.ServiceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.DAO.EmployeeDAO;
import com.mongo.Entity.Employee;
import com.mongo.Repository.EmployeeRepository;
import com.mongo.Service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public String addUser(EmployeeDAO dao) {
        Employee emp = new Employee();
        BeanUtils.copyProperties(dao, emp);
        employeeRepository.save(emp);
        return "Employee "+emp.getName()+" saved.";
    }

    @Override
    public String updateEmployee(EmployeeDAO employeeDAO, int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateEmployee'");
    }

    @Override
    public EmployeeDAO getEmployeeById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEmployeeById'");
    }
    
}
