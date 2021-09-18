import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {ISoTietKiem} from "../interface/SoTietKiem";

@Injectable({
  providedIn: 'root'
})
export class SoTietKiemService {
  public  API: string = 'http://localhost:3000/soTietKiem';
  constructor(public http: HttpClient) { }

  getList(): Observable<ISoTietKiem[]>{
    return this.http.get<ISoTietKiem[]>(this.API);
  }

  getById(id: number): Observable<ISoTietKiem>{
    return this.http.get<ISoTietKiem>(this.API + '/' + id);
  }

  edit(soTietKiem:ISoTietKiem, id: number):Observable<ISoTietKiem>{
    return this.http.put<ISoTietKiem>(this.API + '/' + id, soTietKiem);
  }

  delete(id: number): Observable<ISoTietKiem>{
    return this.http.delete<ISoTietKiem>(this.API + '/' + id);
  }
}
