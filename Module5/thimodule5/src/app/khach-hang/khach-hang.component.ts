import { Component, OnInit } from '@angular/core';
import {ISoTietKiem} from "../interface/SoTietKiem";
import {SoTietKiemService} from "../service/so-tiet-kiem.service";
import {DeleteKhachHangComponent} from "./delete/delete-khach-hang.component";
import {MatDialog} from "@angular/material/dialog";


@Component({
  selector: 'app-khach-hang',
  templateUrl: './khach-hang.component.html',
  styleUrls: ['./khach-hang.component.css']
})
export class KhachHangComponent implements OnInit {

  public soTietKiems!: ISoTietKiem[];
  keyword!: '';
  p: number = 1;

  constructor(public soTietKiemService: SoTietKiemService, public dialog: MatDialog) { }

  ngOnInit(): void {
    this.soTietKiemService.getList().subscribe(data => {
      this.soTietKiems = data;
      console.log(this.soTietKiems);
    });
  }

  openDialog(idCustomer: any): void {
    this.soTietKiemService.getById(idCustomer).subscribe(dataCustomer =>{
      const dialogRef = this.dialog.open(DeleteKhachHangComponent, {
        width: '500px',
        data: {data1: dataCustomer},
        disableClose: true
      });

      dialogRef.afterClosed().subscribe(result => {
        this.ngOnInit();
      });
    });
  }

  search(){
    if (this.keyword == ""){
      this.ngOnInit();
    }else{
      this.soTietKiems = this.soTietKiems.filter(res =>{
        return res.khachHang.tenKhachHang.toLocaleLowerCase().match(this.keyword.toLocaleLowerCase());
      });
    }
  }
}
