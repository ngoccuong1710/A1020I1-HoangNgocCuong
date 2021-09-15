import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {ContractService} from "../../../services/contract.service";
import {ICustomer} from "../../../models/customer";
import {IEmployee} from "../../../models/employee";
import {IService} from "../../../models/service";
import {EmployeeService} from "../../../services/employee.service";
import {CustomerService} from "../../../services/customer.service";
import {ServiceService} from "../../../services/service.service";

@Component({
  selector: 'app-create-contract',
  templateUrl: './create-contract.component.html',
  styleUrls: ['./create-contract.component.css']
})
export class CreateContractComponent implements OnInit {

  public contractCreateForm!: FormGroup;
  public employees!: IEmployee[];
  public customers!: ICustomer[];
  public services!: IService[];

  constructor(
    public formBuilder:FormBuilder,
    public contractService: ContractService,
    public employeeService: EmployeeService,
    public customerService: CustomerService,
    public serviceService: ServiceService,
    public router: Router) {
  }

  ngOnInit(): void {
    this.employeeService.getAllEmployees().subscribe(data =>{
      this.employees = data
    });
    this.customerService.getAllCustomers().subscribe(data =>{
      this.customers = data
    });
    this.serviceService.getAllServices().subscribe(data =>{
      this.services = data
    });

    this.contractCreateForm = this.formBuilder.group({
      'id': [],
      'idContract': [''],
      'startDate': ['', [Validators.required]],
      'endDate': ['', [Validators.required]],
      'deposit': ['', [Validators.required]],
      'totalMoney': ['', [Validators.required]],
      'employee': ['', [Validators.required]],
      'customer': ['', [Validators.required]],
      'service': ['', [Validators.required]],
    })
  }

  addNewContract(){
    this.contractCreateForm.value.idService = "HD-" + Math.floor(Math.random() * 10000);
    this.contractService.addNewContract(this.contractCreateForm.value).subscribe(data => {
      this.router.navigateByUrl('contract-list').then(r => {});
    })
  }

}
