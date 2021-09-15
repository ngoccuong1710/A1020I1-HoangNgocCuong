import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {IContract} from "../models/contract";

@Injectable({
  providedIn: 'root'
})
export class ContractService {
  public  API: string = 'http://localhost:3000/contracts';

  constructor(public http: HttpClient) {}

  getAllContracts(): Observable<IContract>{
    return this.http.get<IContract>(this.API);
  }

  addNewContract(contract: any): Observable<IContract>{
    return  this.http.post<IContract>(this.API, contract)
  }

  getContractById(idContract: any): Observable<IContract>{
    return this.http.get<IContract>(this.API + '/' + idContract);
  }

  deleteContract(idContract: any): Observable<IContract>{
    return this.http.delete<IContract>(this.API + '/' + idContract);
  }

  editContract(contract:any, idContract: any):Observable<IContract>{
    return this.http.put<IContract>(this.API + '/' + idContract, contract);
  }
}
