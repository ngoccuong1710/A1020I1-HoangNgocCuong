import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  public  API: string = 'http://localhost:3000/customers';

  constructor(public http: HttpClient) {}

  getAllCustomers(): Observable<any>{
    return this.http.get(this.API);
  }

  addNewCustomer(customer: any): Observable<any>{
    return  this.http.post(this.API, customer)
  }

  getCustomerById(idCustomer: any): Observable<any>{
    return this.http.get(this.API + '/' + idCustomer);
  }

  deleteCustomer(idCustomer: any): Observable<any>{
    return this.http.delete(this.API + '/' + idCustomer);
  }

  editCustomer(customer:any, idCustomer: any):Observable<any>{
    return this.http.put(this.API + '/' + idCustomer, customer);
  }
}
