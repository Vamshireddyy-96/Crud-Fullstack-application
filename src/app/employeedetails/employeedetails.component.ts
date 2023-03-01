import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employeedetails',
  templateUrl: './employeedetails.component.html',
  styleUrls: ['./employeedetails.component.css']
})
export class EmployeedetailsComponent implements OnInit {
  id:number
  employee:Employee
  
  constructor(private route:ActivatedRoute,private employeeService:EmployeeService){}
 
  ngOnInit(): void {
    this.id =this.route.snapshot.params['id'];
   this.employee=new Employee();
   this.employeeService.getEmployeeById(this.id).subscribe(data=>{
   this.employee=data;
   });
  }

}
