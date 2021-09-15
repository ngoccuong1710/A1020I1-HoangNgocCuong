import { Component, OnInit } from '@angular/core';
import {FormGroup, FormBuilder, Validators} from "@angular/forms";
import {CustomerService} from "../../../services/customer.service";
import {Router} from "@angular/router";

interface Type {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {

  public customerCreateForm!: FormGroup;
  public maxDate = new Date();
  public minDate = new Date(1900, 0,1);

  constructor(
    public formBuilder:FormBuilder,
    public customerService: CustomerService,
    public router: Router) {}

  ngOnInit(): void {
    this.customerCreateForm = this.formBuilder.group({
      'id': [],
      'idCustomer': [''],
      'name': ['', [Validators.required]],
      'birthday': ['', [Validators.required]],
      'gender': ['', [Validators.required]],
      'idCard': ['', [Validators.required, Validators.pattern('^[0-9]{9}$')]],
      'phone': ['', [Validators.required, Validators.pattern('^((\\(84\\)\\+)|(0))((91)|(90))[\\d]{7}$')]],
      'email': ['', [Validators.required, Validators.email]],
      'address': ['', [Validators.required]],
      'type': ['', [Validators.required]],
    })
  }

  addNewCustomer(){
    this.customerCreateForm.value.idCustomer = "KH-" + Math.floor(Math.random() * 10000);
    this.customerService.addNewCustomer(this.customerCreateForm.value).subscribe(data => {
      this.router.navigateByUrl('customer-list').then(r => {});
    })
  }

  types: Type[] = [
    {value: 'Diamond', viewValue: 'Diamond'},
    {value: 'Platinum', viewValue: 'Platinium'},
    {value: 'Gold', viewValue: 'Gold'},
    {value: 'Silver', viewValue: 'Silver'},
    {value: 'Member', viewValue: 'Menber'},
  ];
}

