import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
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
  selector: 'app-edit-employee',
  templateUrl: './edit-employee.component.html',
  styleUrls: ['./edit-employee.component.css']
})
export class EditEmployeeComponent implements OnInit {

  public employeeEditForm!: FormGroup;
  public idEmployee: any;

  constructor(
    public formBuilder:FormBuilder,
    public employeeService: EmployeeService,
    public router: Router,
    public activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.employeeEditForm = this.formBuilder.group({
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
    });

    this.activatedRoute.params.subscribe(data =>{
      this.idEmployee = data.id;
      this.employeeService.getEmployeesById(this.idEmployee).subscribe(data =>{
        this.employeeEditForm.patchValue(data);
      })
    })
  }

  editEmployee() {
    this.employeeService.editEmployees(this.employeeEditForm.value, this.idEmployee).subscribe(data =>{
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
