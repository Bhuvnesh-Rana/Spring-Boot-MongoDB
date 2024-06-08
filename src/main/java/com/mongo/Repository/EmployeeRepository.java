package com.mongo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongo.Entity.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,Integer> {
    
}
