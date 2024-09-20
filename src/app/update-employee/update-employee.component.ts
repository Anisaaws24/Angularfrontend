import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { ActivatedRoute } from '@angular/router';
import { Employee } from '../employee';
import { Router } from '@angular/router';
import { error } from 'console';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrl: './update-employee.component.css'
})
export class UpdateEmployeeComponent implements OnInit {
onSubmit() {
  this.employeeservice.updateEmployee(this.id,this.employee).subscribe(data =>
    {

      this.goToEmployeeList();
      this.employee=data;
    })
}
  id:number=0;
  
   employee:Employee=new Employee();
  constructor(private employeeservice:EmployeeService,private route:ActivatedRoute,private router:Router){}
  ngOnInit(){
    this.id=this.route.snapshot.params['id'];
  
    this.employeeservice.getEmployeebyId(this.id).subscribe(data =>
      
      {
      console.log(data);
     
      //this.employee=data;
      //this.goToEmployeeList();
     
    }, error => console.log(error));
  
   
  }
  goToEmployeeList()
  {
    this.router.navigate(['/employees/']);
  }
  
}


