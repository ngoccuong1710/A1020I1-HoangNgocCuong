import {Component, OnInit} from '@angular/core';
import {CustomerService} from "../../../services/customer.service";
import {ICustomer} from "../../../models/customer";
import {MatDialog} from "@angular/material/dialog";
import {DeleteCustomerComponent} from "../delete-customer/delete-customer.component";

interface Type {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {

  types: Type[] = [
    {value: 'Diamond', viewValue: 'Diamond'},
    {value: 'Platinum', viewValue: 'Platinium'},
    {value: 'Gold', viewValue: 'Gold'},
    {value: 'Silver', viewValue: 'Silver'},
    {value: 'Member', viewValue: 'Menber'},
  ];

  public customers!: ICustomer[];
  public keyword!: '';
  public p: number = 1;
  public searchName = '';
  public searchCustomerType = '';

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

  // search() {
  //   this.customerService.searchCustomer(this.searchName, this.searchCustomerType).subscribe(data => {
  //     this.customers = data;
  //   });
  // }

  search(){
    if (this.searchName == ""){
      this.ngOnInit();
    }else{
      this.customers = this.customers.filter(res =>{
        return res.name.toLocaleLowerCase().match(this.searchName.toLocaleLowerCase()) || res.address.toLocaleLowerCase().match(this.searchName.toLocaleLowerCase());
      });
    }
  }

}
