import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {IKhachHang} from "../interface/KhachHang";

@Injectable({
  providedIn: 'root'
})
export class KhachHangService {
  public  API: string = 'http://localhost:3000/';

  constructor(public http: HttpClient) { }

  getList(): Observable<IKhachHang[]>{
    return this.http.get<IKhachHang[]>(this.API);
  }

  getById(id: number): Observable<IKhachHang>{
    return this.http.get<IKhachHang>(this.API + '/' + id);
  }

  edit(khachHang:IKhachHang, id: number):Observable<IKhachHang>{
    return this.http.put<IKhachHang>(this.API + '/' + id, khachHang);
  }

  delete(id: number): Observable<IKhachHang>{
    return this.http.delete<IKhachHang>(this.API + '/' + id);
  }
}
