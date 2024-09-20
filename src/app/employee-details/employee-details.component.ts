import { Component, input, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { ActivatedRoute } from '@angular/router';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrl: './employee-details.component.css'
})
export class EmployeeDetailsComponent implements OnInit {
 
  id:number=0;
  employee:Employee =new Employee();
  constructor(private route:ActivatedRoute,private employeeservice:EmployeeService)
  {}

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
   
    this.employeeservice.getEmployeebyId(this.id).subscribe(data =>{
     //this.employee=data;
     
     console.log(data);
    
    });
  }

}
