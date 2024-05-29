package com.SpringBootProjectExam.Service;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.SpringBootProjectExam.Entity.Employee;

public interface EmployeeServiceInterface {

	  public Employee createEmployee(Employee employee);
	  
	  public List<Employee> GetAllEmployee();
	  
	  public Employee FindEmployeeByID(Long id);
	  
	  public Employee UpdateEmployee (Employee employee);
	  
	  public void DeleteEmployee (Long id);
}
