import { Component, OnInit } from '@angular/core';
import {EmployeeService} from "../../../services/employee.service";
import {IEmployee} from "../../../models/employee";
import {DeleteEmployeeComponent} from "../delete-employee/delete-employee.component";
import {MatDialog} from "@angular/material/dialog";

@Component({
  selector: 'app-list-employee',
  templateUrl: './list-employee.component.html',
  styleUrls: ['./list-employee.component.css']
})
export class ListEmployeeComponent implements OnInit {

  public employees!: IEmployee;
  keyword!: '';
  p: number = 1;

  constructor(public employeeService: EmployeeService, public dialog: MatDialog) { }

  ngOnInit(): void {
    this.employeeService.getAllEmployees().subscribe(data => {
      this.employees = data;
      console.log(this.employees);
    });
  }

  openDialog(idEmployee: any): void {
    this.employeeService.getEmployeesById(idEmployee).subscribe(dataEmployee =>{
      const dialogRef = this.dialog.open(DeleteEmployeeComponent, {
        width: '500px',
        data: {data1: dataEmployee},
        disableClose: true
      });

      dialogRef.afterClosed().subscribe(result => {
        this.ngOnInit();
      });
    });
  }

}
