package com.sirajul.springbootcrud.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sirajul.springbootcrud.domain.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{ 
}
