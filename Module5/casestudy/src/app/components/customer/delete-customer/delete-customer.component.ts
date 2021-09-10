import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {CustomerService} from "../../../services/customer.service";

@Component({
  selector: 'app-delete-customer',
  templateUrl: './delete-customer.component.html',
  styleUrls: ['./delete-customer.component.css']
})
export class DeleteCustomerComponent implements OnInit {
  public nameCustomer: any;
  public idCustomer: any;

  constructor(
    public dialogRef: MatDialogRef<DeleteCustomerComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public customerService: CustomerService) {}

  ngOnInit(): void {
   this.nameCustomer = this.data.data1.name;
    this.idCustomer = this.data.data1.id;
  }

  deleteCustomer(){
    this.customerService.deleteCustomer(this.idCustomer).subscribe(data =>{
      this.dialogRef.close();
    })
  }

}
