package com.sirajul.springbootcrud.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sirajul.springbootcrud.domain.Employee;
import com.sirajul.springbootcrud.repositories.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	
	private final EmployeeService employeeService;
	
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}


	@GetMapping( value="")
	public String getAllEmployees(Model model) {
		model.addAttribute("employee",employeeService.getAllEmployees());
		return "employee/list";
	}
	
	
	@GetMapping(value="show/{id}")
	
	public String showByEmployee(@PathVariable Long id, Model model) {
		
		Optional<Employee> emOptional = employeeService.getEmployeeById(id);
		if(emOptional.isPresent()) {
			model.addAttribute("employee",emOptional.get());
		}
		
			return "employee/show";
	}
	
	
	
	@GetMapping(value="new")
	public String newEmployee(Employee employee) {
		return "employee/new";
	}
	
	@PostMapping("add")
    public String addEmployee(@Valid Employee employee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:new";
        }

        employeeService.saveEmployee(employee);
        return "redirect:";
    }

	@GetMapping("delete/{id}")
    public String deleteEmployee(@PathVariable("id") long id, Model model) {
	
		employeeService.deleteEmployee(id);
		
    model.addAttribute("employee", employeeService.getAllEmployees());
        return getAllEmployees(model);
    }
	
	
	@GetMapping("update/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Optional<Employee> emOptional = employeeService.getEmployeeById(id);
		if(emOptional.isPresent()) {
			model.addAttribute("employee",emOptional.get());
		}
		
        return "employee/update";
    }
	
	@PostMapping("update/{id}")
    public String updateEmployee(@PathVariable("id") long id, @Valid Employee employee, BindingResult result,
        Model model) {
        if (result.hasErrors()) {
            employee.setId(id);
            return "employee/update";
        }

        employeeService.saveEmployee(employee);
        model.addAttribute("employee", employeeService.getAllEmployees());
        return getAllEmployees(model);
    }

	
	
	

}
