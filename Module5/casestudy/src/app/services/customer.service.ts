import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ICustomer} from "../models/customer";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  public  API: string = 'http://localhost:3000/customers';

  constructor(public http: HttpClient) {}

  getAllCustomers(): Observable<ICustomer[]>{
    return this.http.get<ICustomer[]>(this.API);
  }

  addNewCustomer(customer: ICustomer): Observable<ICustomer>{
    return  this.http.post<ICustomer>(this.API, customer)
  }

  getCustomerById(idCustomer: number): Observable<ICustomer>{
    return this.http.get<ICustomer>(this.API + '/' + idCustomer);
  }

  deleteCustomer(idCustomer: number): Observable<ICustomer>{
    return this.http.delete<ICustomer>(this.API + '/' + idCustomer);
  }

  editCustomer(customer:ICustomer, idCustomer: number):Observable<ICustomer>{
    return this.http.put<ICustomer>(this.API + '/' + idCustomer, customer);
  }

  searchCustomer(name: any, customerType: any): Observable<ICustomer[]> {
    return this.http.get<ICustomer[]>(this.API + '?name_like=' + name + '?customerType_like=' + customerType);
  }

}
