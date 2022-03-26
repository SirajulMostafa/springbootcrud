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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	
	//for update modal get request
	@GetMapping("updateModal/{id}")
	@ResponseBody
  public Optional<Employee> updateModal(@PathVariable("id") long id) {
		System.out.println("updateModalRequest");
		return employeeService.getEmployeeById(id);
  }
	
	
	@PostMapping(value="/addNewEmployee")
	public String addNewEmployee(Employee employee) {
		System.out.println("addnewEmployee fired");
		employeeService.addNewEmployee(employee);
		return "redirect:";
	}
	
	
	@PostMapping(value="update")
	public String update(Employee employee) {
		System.out.println("updateEmployee");
		employeeService.updateEmployee(employee);
		return "redirect:";
	}
	

}
