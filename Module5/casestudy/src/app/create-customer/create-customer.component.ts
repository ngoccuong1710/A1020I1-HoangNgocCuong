import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {

  customerForm: FormGroup;

  constructor() {
    this.customerForm = new FormGroup({
      'idCustomer': new FormControl(null),
      'name': new FormControl(),
      'birthday': new FormControl(),
      'gender': new FormControl(),
      'idCard': new FormControl(),
      'phone': new FormControl(),
      'email': new FormControl(),
      'address': new FormControl(),
      'type': new FormControl(),
    })
  }

  onSubmit(){
    if (this.customerForm.invalid){
      console.log("Invalid data");
      return;
    }
    console.log(this.customerForm.value)
  }

  ngOnInit(): void {
  }

}
