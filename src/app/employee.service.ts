import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Employee } from './employee';
import{Observable}from'rxjs';
import { identifierName } from '@angular/compiler';
@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
 
  /* getEmployeeList() {
    throw new Error('Method not implemented.');
  } */

  private baseURL="http://localhost:8080/api/employees";
  constructor(private httpClient:HttpClient) { }

  getEmployeesList():Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(this.baseURL);

  }
  createEmployee(employee:Employee):Observable<Object>{
      return this.httpClient.post((this.baseURL),employee);
  }
  getEmployeeById(id: number): Observable<any> {
    return this.httpClient.get(`${this.baseURL}/${id}`);
  }
  updateEmployee(id: number, value: any): Observable<Object> {
    return this.httpClient.put(`${this.baseURL}/${id}`, value);
  }
  deleteEmployee(id: number): Observable<any> {
    return this.httpClient.delete(`${this.baseURL}/${id}`, { responseType: 'text' });
  }
 
 
}
