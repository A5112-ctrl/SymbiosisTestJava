package com.SpringBootProjectExam.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SpringBootProjectExam.Entity.Employee;
import com.SpringBootProjectExam.Service.EmployeeService;

import jakarta.validation.Valid;

@Controller
public class AllEmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping("/saveEmployees")
	public String SaveEmp(Model model) {
		model.addAttribute("newemp",new Employee());
		return "newEmployee";
	}
	
	@PostMapping("/employeeAdded")
	public String employeeAdd(@Valid @ModelAttribute("newemp")Employee employee,BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
			return "newEmployee";
		}
		else {
		service.createEmployee(employee);
		model.addAttribute("message", "employee added successfully");
		return "newEmployee";
		}
		
	}
	
	@GetMapping("/existingEmployee")
	public String existingEmp(Model model) {
		List<Employee> list=service.GetAllEmployee();
//		for(Employee e:list) {
//			System.out.println(e.getFirstName());
//		}
		model.addAttribute("employees", list);
		return "existingEmployee";
		
	}
	
	@PostMapping("/deleteExisting")
	public String deleteEmp(@RequestParam("id") long id) {
		service.DeleteEmployee(id);
		return "redirect:/existingEmployee";
		
	}
	
	@GetMapping("/updatedExisting")
	public String updateEmpForm(@RequestParam("id" )long id,Model model) {
		Employee emp=service.FindEmployeeByID(id);
		//System.out.println(emp);
		model.addAttribute("emp", emp);
		return "updateEmployee";
	}
	
	@PostMapping("/empUpdateSucc")
	public String updatedSuccess(@Valid @ModelAttribute("emp") Employee bt, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "updateEmployee";
		}
		
		else {
		Employee b=service.UpdateEmployee(bt);
		//System.out.println(b);
		model.addAttribute("message", "employee updated successfully");
		return "redirect:/existingEmployee";
		}
	}
	
	

}