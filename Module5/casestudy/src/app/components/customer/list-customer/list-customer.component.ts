import {Component, OnInit} from '@angular/core';
import {CustomerService} from "../../../services/customer.service";
import {ICustomer} from "../../../models/customer";
import {MatDialog} from "@angular/material/dialog";
import {DeleteCustomerComponent} from "../delete-customer/delete-customer.component";


@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {

  public customers!: ICustomer;
  keyword!: '';
  p: number = 1;

  constructor(public customerService: CustomerService, public dialog: MatDialog) { }

  ngOnInit(): void {
    this.customerService.getAllCustomers().subscribe(data => {
      this.customers = data;
      console.log(this.customers);
    },
        error => {
      console.log("CÓ lỗi xảy ra!")
    });
  }

  openDialog(idCustomer: any): void {
    this.customerService.getCustomerById(idCustomer).subscribe(dataCustomer =>{
      const dialogRef = this.dialog.open(DeleteCustomerComponent, {
        width: '500px',
        data: {data1: dataCustomer},
        disableClose: true
      });

      dialogRef.afterClosed().subscribe(result => {
        this.ngOnInit();
      });
    });
  }
}
