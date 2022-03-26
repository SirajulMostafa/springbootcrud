package com.sirajul.springbootcrud.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sirajul.springbootcrud.domain.Employee;

@Service
public interface EmployeeService {

	    Employee saveEmployee(Employee employee);
	    Employee addNewEmployee(Employee employee);
	    List<Employee> getAllEmployees();
	    Optional<Employee> getEmployeeById(long id);
	    Employee updateEmployee(Employee updatedEmployee);
	    void deleteEmployee(long id);
	    
}

