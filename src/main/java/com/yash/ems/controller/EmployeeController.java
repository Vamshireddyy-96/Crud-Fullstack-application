package com.yash.ems.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.ems.exception.ResourceNotFoundException;
import com.yash.ems.model.Employee;
import com.yash.ems.repository.EmployeeRepository;

@CrossOrigin("http://localhost:62336")
@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	private Object employee;
	
	//get all employees
	@GetMapping("/employees")
	public List<Employee>getAllEmployees(){
		return employeeRepository.findAll();
		}
	//create the employee
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
		}
	//get employee by id
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id ) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not Exist With id:"+id));
				return ResponseEntity.ok(employee);
	}
		
	//updated employee by using id
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> e( @PathVariable Long id,@RequestBody Employee employee){
		Employee employee1 = employeeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not Exist With id:"+id));
		employee.setFirstName(employee.getFirstName());
		employee.setFirstName(employee.getFirstName());
		employee.setFirstName(employee.getFirstName());
	Employee updateEmployee = employeeRepository.save(employee);
	return ResponseEntity.ok(updateEmployee);
		
	}
	//delete employee rest api
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Employee employee= employeeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not Exist With id:"+id));
		employeeRepository.delete(employee);
		Map<String,Boolean>response=new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
			
	}
	
	
}
