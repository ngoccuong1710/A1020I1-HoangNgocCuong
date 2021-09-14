import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {DeleteCustomerComponent} from "../../customer/delete-customer/delete-customer.component";
import {EmployeeService} from "../../../services/employee.service";

@Component({
  selector: 'app-delete-employee',
  templateUrl: './delete-employee.component.html',
  styleUrls: ['./delete-employee.component.css']
})
export class DeleteEmployeeComponent implements OnInit {
  public nameEmployee: any;
  public idEmployee: any;

  constructor(
    public dialogRef: MatDialogRef<DeleteCustomerComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.nameEmployee = this.data.data1.name;
    this.idEmployee = this.data.data1.id;
  }

  deleteEmployee(){
    this.employeeService.deleteEmployees(this.idEmployee).subscribe(data =>{
      this.dialogRef.close();
    })
  }

}
