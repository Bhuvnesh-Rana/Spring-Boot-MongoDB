package com.mongo.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

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
        Employee employee = employeeRepository.findById(id).get();
        employee.setId(employeeDAO.getId());
        employee.setName(employeeDAO.getName());
        employee.setDepartment(employeeDAO.getDepartment());
        employeeRepository.save(employee);

        return "Employee data updated.";
    }

    @Override
    public EmployeeDAO getEmployeeById(int id) {
        Employee emp = employeeRepository.findById(id).get();
        EmployeeDAO employeeDAO = entityToDao(emp);

        return employeeDAO;
    }

    @Override
    public List<EmployeeDAO> getAllEmployee() {
        List<Employee> emp = employeeRepository.findAll();
        List<EmployeeDAO> employeeDAO = emp.stream().map(a -> entityToDao(a)).collect(Collectors.toList());

        return employeeDAO;
    }

    @Override
    public String deleteEmployee(int id) {
        employeeRepository.deleteById(id);
        return "EMployee deleted.";
    }

    private EmployeeDAO entityToDao(Employee employee){
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.setId(employee.getId());
        employeeDAO.setName(employee.getName());
        employeeDAO.setDepartment(employee.getDepartment());

        return employeeDAO;
    }

    // private Employee daoToEntity( EmployeeDAO employeeDAO){
    //     Employee employee = new Employee();
    //     employee.setId(employeeDAO.getId());
    //     employee.setName(employeeDAO.getName());
    //     employee.setDepartment(employeeDAO.getDepartment());

    //     return employee;
    // }
    
}
