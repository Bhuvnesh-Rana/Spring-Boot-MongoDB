package com.mongo.ServiceImpl;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.mongo.DAO.EmployeeDAO;
import com.mongo.Entity.Employee;
import com.mongo.Repository.EmployeeRepository;
import com.mongo.Service.EmployeeService;

public class EmployeeServiceImplTest {


    @Mock
    private EmployeeRepository employeeRepository;
    private EmployeeService employeeService;
    AutoCloseable autoCloseable;
    Employee employee;

    @BeforeEach
    void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this);
        employeeService = new EmployeeServiceImpl(employeeRepository);
        employee = new Employee(1, "Random", "HR");
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    private EmployeeDAO entityToDao(Employee employee){
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.setId(employee.getId());
        employeeDAO.setName(employee.getName());
        employeeDAO.setDepartment(employee.getDepartment());

        return employeeDAO;
    }

    @Test
    void testAddUser() {
        mock(EmployeeDAO.class);
        mock(EmployeeRepository.class);

        when(employeeRepository.save(employee)).thenReturn(employee);
        EmployeeDAO employeeDAO = entityToDao(employee);
        assertThat(employeeService.addUser(employeeDAO)).isEqualTo("Employee "+employee.getName()+" saved.");

    }

    @Test
    void testDeleteEmployee() {
        mock(EmployeeDAO.class);
        mock(EmployeeRepository.class, Mockito.CALLS_REAL_METHODS);

        doAnswer(Answers.CALLS_REAL_METHODS).when(employeeRepository).deleteById(1);
        assertThat(employeeService.deleteEmployee(1)).isEqualTo("Employee deleted.");
    }

    @Test
    void testGetAllEmployee() {

    }

    @Test
    void testGetEmployeeById() {

    }

    @Test
    void testUpdateEmployee() {

    }
}
