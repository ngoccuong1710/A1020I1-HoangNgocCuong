import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CustomerService} from "../../../services/customer.service";
import {Router, ActivatedRoute} from "@angular/router";

interface Type {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {

  public customerEditForm!: FormGroup;
  public idCustomer: any;

  constructor(
    public formBuilder:FormBuilder,
    public customerService: CustomerService,
    public router: Router,
    public activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.customerEditForm = this.formBuilder.group({
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
    });

    this.activatedRoute.params.subscribe(data =>{
      this.idCustomer = data.id;
      this.customerService.getCustomerById(this.idCustomer).subscribe(data =>{
        this.customerEditForm.patchValue(data);
      })
    })
  }

  editCustomer() {
    this.customerService.editCustomer(this.customerEditForm.value, this.idCustomer).subscribe(data =>{
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
