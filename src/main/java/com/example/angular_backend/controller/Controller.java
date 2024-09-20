package com.example.angular_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


import com.example.angular_backend.Model.Employee;
import com.example.angular_backend.Repository.EmpRepository;
import com.example.angular_backend.service.Empservice;




@RestController
@CrossOrigin(origins="http://localhost:4200")
public class Controller {
	
	@Autowired
	private Empservice emp2;

	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("/employees/")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp)
	{
		
		return new ResponseEntity<Employee>(emp2.saveEmployee(emp),HttpStatus.CREATED);
		
		
	}
	@GetMapping("/employees/")
	public List<Employee> getAllEmployees()
	{
		
		return emp2.getAllEmployee();
	}
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) 
		{
			
		
			return new ResponseEntity<Employee>(emp2.getEmployeeById(id),HttpStatus.OK);
		}
	@PutMapping("/employees/{id}")

	public ResponseEntity<Employee> updateEmployee(@PathVariable("id")int id,@RequestBody Employee emp)
	{
		return new ResponseEntity<Employee>(emp2.updateEmployee(emp, id),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id")int id)

	{
		emp2.DeleteEmployee(id);
	    return new ResponseEntity<String>("Student deleted successfully",HttpStatus.OK);
	}

	
	

}
