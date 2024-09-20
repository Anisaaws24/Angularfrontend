package com.example.angular_backend.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.example.angular_backend.Exception.ResourceNotFoundException;
import com.example.angular_backend.Model.Employee;
import com.example.angular_backend.Repository.EmpRepository;
import com.example.angular_backend.service.Empservice;




@Service
public class Empserviceimpl implements Empservice{
	@Autowired
	private EmpRepository repo;
	
	
	

	public Empserviceimpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return repo.save(emp);
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<Employee> insertAllEmployee(List<Employee> s) {
		// TODO Auto-generated method stub
		return repo.saveAll(s);
	}

	@Override
	public void DeleteEmployee(int id) {
		
		repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
		repo.deleteById(id);
		
		
	}

	@Override
	public Employee updateEmployee(Employee emp, int id) {
		// TODO Auto-generated method stub
		//return null;
		Employee  existingEmployee=repo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Employee","Id",id));
		
		existingEmployee.setFirstName(emp.getFirstName());
		existingEmployee.setLastName(emp.getLastName());
		existingEmployee.setEmailId(emp.getEmailId());
		
		 return repo.save(existingEmployee);
		 
	}

	@Override
	public String deleteEmployee(String rparam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> emp=repo.findById(id);
		if(emp.isPresent())
		{
			return emp.get();
		}
		else
		{
			throw new ResourceNotFoundException("Employee","Id",id);
		}
	}

	

	
	

	

}
