package com.mongo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.Entity.Employee;

public interface EmployeeRepository extends MongoRepository<Employee,Integer> {
    
}
