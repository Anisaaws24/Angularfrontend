package com.example.angular_backend.service;

import java.util.List;


import com.example.angular_backend.Model.Employee;


public interface Empservice {
	
Employee saveEmployee(Employee emp);
	
	List<Employee>getAllEmployee();
	List<Employee>insertAllEmployee(List <Employee> s);
	
	String deleteEmployee(String rparam);
	
	void DeleteEmployee(int id);
	
	Employee getEmployeeById(int id);
	Employee updateEmployee(Employee emp,int id);
	
	

}
