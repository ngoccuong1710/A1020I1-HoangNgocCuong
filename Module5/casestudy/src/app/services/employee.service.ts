import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  public  API: string = 'http://localhost:3000/employees';

  constructor(public http: HttpClient) { }

  getAllEmployees(): Observable<any>{
    return this.http.get(this.API);
  }

  addNewEmployees(employee: any): Observable<any>{
    return  this.http.post(this.API, employee)
  }

  getEmployeesById(idEmployee: any): Observable<any>{
    return this.http.get(this.API + '/' + idEmployee);
  }

  deleteEmployees(idEmployee: any): Observable<any>{
    return this.http.delete(this.API + '/' + idEmployee);
  }

  editEmployees(employee:any, idEmployee: any):Observable<any>{
    return this.http.put(this.API + '/' + idEmployee, employee);
  }
}
