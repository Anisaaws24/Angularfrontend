import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';


@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
 
  private baseURL="http://localhost:8080/employees/";
  
  
  constructor( private http:HttpClient) { }

  getEmployeeList():Observable<Employee[]>
  {
    return this.http.get<Employee[]>(this.baseURL);
  }
  createEmployee(employee:Employee):Observable<object>
  {
    return this.http.post(this.baseURL,employee);
  }

  getEmployeebyId(id:number):Observable<object>
  {
    return this.http.get<Employee>(this.baseURL+id);
  }
  updateEmployee(id:number,employee:Employee):Observable<Employee>
  {
    return this.http.put<Employee>(this.baseURL+id,employee);
  }
  deleteEmployee(id:number):Observable<object
  >
  {
    return this.http.delete<Employee>(this.baseURL+id);
  }
}
