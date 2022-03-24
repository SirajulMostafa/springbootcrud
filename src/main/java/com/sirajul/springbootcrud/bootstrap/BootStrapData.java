package com.sirajul.springbootcrud.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sirajul.springbootcrud.domain.Employee;
import com.sirajul.springbootcrud.repositories.EmployeeRepository;

@Component
public class BootStrapData implements CommandLineRunner {
	private final EmployeeRepository employeeRepository;
	

	public BootStrapData(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Employee emp = new Employee("abc","Mostafa","email123@gmail.com","28");
		Employee emp1 = new Employee("Akbar","Hossain","akbar@gmail.com","23");
		Employee emp2 = new Employee("Hossain","Rahman","hossain@gmail.com","29");
		Employee emp3 = new Employee("Hossain1","Rahman1","hossain1@gmail.com","29");
		
	employeeRepository.save(emp);
	employeeRepository.save(emp1);
	employeeRepository.save(emp2);
	employeeRepository.save(emp3);
	System.out.println("start bootstrap: employee auto create number" +employeeRepository.count());
	}

}
