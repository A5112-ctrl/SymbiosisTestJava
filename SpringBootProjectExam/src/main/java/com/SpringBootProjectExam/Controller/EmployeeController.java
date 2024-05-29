package com.SpringBootProjectExam.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.SpringBootProjectExam.Entity.Employee;
import com.SpringBootProjectExam.Service.EmployeeService;

@Controller
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployees() {
	        return employeeService.GetAllEmployee();
	    }


	@PostMapping("/AddEmployee")
	public Employee addEmployee(Employee employee) {
	        return employeeService.createEmployee(employee);
	    }

	
	@PutMapping("/UpdateEmployee")
	public Employee updateEmployee( Employee employee) {
	        return employeeService.UpdateEmployee(employee);
	    }

	@DeleteMapping("/DeleteEmployee")
	public void deleteEmployeeById(Long id) {
	        employeeService.DeleteEmployee(id);
	    }
	}

	
	

