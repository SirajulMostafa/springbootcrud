package com.sirajul.springbootcrud.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sirajul.springbootcrud.domain.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService  {
	
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeById(long id) {
		System.out.println(employeeRepository.findById(id).toString());
		return employeeRepository.findById(id);
		 
	}

	@Override
	public Employee updateEmployee(Employee updatedEmployee) {
		return employeeRepository.save(updatedEmployee);
	}

	@Override
	public void deleteEmployee(long id) {
		Employee employee = employeeRepository.findById(id).get();
		System.out.println(employee.toString());
		        employeeRepository.delete(employee);
		
	}

	@Override
    public Employee saveEmployee(Employee employee) {
        
        return employeeRepository.save(employee);
    }


}
