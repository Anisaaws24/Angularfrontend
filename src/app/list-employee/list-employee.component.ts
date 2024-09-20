import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { Route } from '@angular/router';
import { Router } from '@angular/router';
import { subscribe } from 'diagnostics_channel';

@Component({
  selector: 'app-list-employee',
  templateUrl: './list-employee.component.html',
  styleUrl: './list-employee.component.css'
})
export class ListEmployeeComponent implements OnInit {
  constructor(private employeeservice:EmployeeService,private router:Router){}
  employees:Employee[]=[];
  ngOnInit(): void {
    this.getEmployeeList();
    }
    getEmployeeList(){
      this.employeeservice.getEmployeeList().subscribe(data =>{
        this.employees=data;
      })
    }

    updateEmployee(id:number)
    {
      this.router.navigate(['update-employee',id]);
    }
    viewEmployee(id:number){
      this.router.navigate(['employee-details',id]);
    }
   deleteEmployee(id:number)
   {
    this.employeeservice.deleteEmployee(id).subscribe(data =>{
      console.log(data);
      this.getEmployeeList();
    
      //this.getEmployeeList();this.getemployees();
    })
   }
  

  

}
