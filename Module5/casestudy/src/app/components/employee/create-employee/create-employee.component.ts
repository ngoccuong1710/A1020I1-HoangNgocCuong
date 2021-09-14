import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {EmployeeService} from "../../../services/employee.service";

interface Position {
  value: string;
  viewValue: string;
}

interface EducationDegree {
  value: string;
  viewValue: string;
}

interface Division {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  public employeeCreateForm!: FormGroup;

  constructor(
    public formBuilder:FormBuilder,
    public employeeService: EmployeeService,
    public router: Router) {}

  ngOnInit(): void {
    this.employeeCreateForm = this.formBuilder.group({
      'id': [],
      'idEmployee': [''],
      'name': ['', [Validators.required]],
      'birthday': ['', [Validators.required]],
      'idCard': ['', [Validators.required, Validators.pattern('^[0-9]{9}$')]],
      'salary': ['', [Validators.required, Validators.pattern('^[0-9]$')]],
      'phone': ['', [Validators.required, Validators.pattern('^((\\(84\\)\\+)|(0))((91)|(90))[\\d]{7}$')]],
      'email': ['', [Validators.required, Validators.email]],
      'address': ['', [Validators.required]],
      'position': ['', [Validators.required]],
      'educationDegree': ['', [Validators.required]],
      'division': ['', [Validators.required]],
    })
  }

  addNewEmployee(){
    this.employeeCreateForm.value.idEmployee = "NV-" + Math.floor(Math.random() * 10000);
    this.employeeService.addNewEmployees(this.employeeCreateForm.value).subscribe(data => {
      this.router.navigateByUrl('employee-list').then(r => {});
    })
  }

  positions: Position[] = [
    {value: 'Lễ tân', viewValue: 'Lễ tân'},
    {value: 'Phục vụ', viewValue: 'Phục vụ'},
    {value: 'Chuyên viên', viewValue: 'Chuyên viên'},
    {value: 'Giám sát', viewValue: 'Giám sát'},
    {value: 'Quản lý', viewValue: 'Quản lý'},
    {value: 'Giám đốc', viewValue: 'Giám đốc'},
  ];

  educationDegrees: EducationDegree[] = [
    {value: 'Trung cấp', viewValue: 'Trung cấp'},
    {value: 'Cao đẳng', viewValue: 'Cao đẳng'},
    {value: 'Đại học', viewValue: 'Đại học'},
    {value: 'Sau đại học', viewValue: 'Sau đại học'},
  ];

  divisions: Division[] = [
    {value: 'Sale – Marketing', viewValue: 'Sale – Marketing'},
    {value: 'Hành Chính', viewValue: 'Hành Chính'},
    {value: 'Phục vụ', viewValue: 'Phục vụ'},
    {value: 'Quản lý', viewValue: 'Quản lý'},
  ];

}
