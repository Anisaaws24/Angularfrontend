package com.example.angular_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.angular_backend.Model.Employee;



@Repository
public interface EmpRepository extends JpaRepository<Employee,Integer> {

}
