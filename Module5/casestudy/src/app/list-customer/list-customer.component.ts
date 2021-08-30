import { Component, OnInit } from '@angular/core';
import {ICustomer} from "../common/customer";

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {

  customers: ICustomer[] = [
    {
      idCustomer: "1",
      name: "cuong",
      birthday: "17/10/1999",
      gender: "nam",
      idCard: "123123123",
      phone: "0365797021",
      email: "cuong@gmail.com",
      address: "da nang",
      type: "diamond",
    }
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
