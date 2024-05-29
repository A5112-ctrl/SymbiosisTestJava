package com.SpringBootProjectExam.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootProjectExam.Entity.Employee;
import com.SpringBootProjectExam.Repository.EmployeeRepository;

@Service
public class EmployeeService implements EmployeeServiceInterface{

	public EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	// Create 
	  public Employee createEmployee(Employee employee) {
	        return employeeRepository.save(employee);
	    }
	
	  
	  //Read 
	  public List<Employee>GetAllEmployee(){
		return employeeRepository.findAll();  
	  }
	  
	  public Employee FindEmployeeByID(Long id) {
		  return employeeRepository.findById(id).get();
	  }
	  
	  //Update
	  
	  public Employee UpdateEmployee(Employee employee) {
		  return employeeRepository.save(employee);
	  }
	  
	  //Delete 
	  
	  public void DeleteEmployee (Long id) {
		   employeeRepository.deleteById(id);
	  }
}
