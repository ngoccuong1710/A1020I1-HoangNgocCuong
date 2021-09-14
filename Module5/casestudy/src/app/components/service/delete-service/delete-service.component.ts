import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {DeleteCustomerComponent} from "../../customer/delete-customer/delete-customer.component";
import {ServiceService} from "../../../services/service.service";

@Component({
  selector: 'app-delete-service',
  templateUrl: './delete-service.component.html',
  styleUrls: ['./delete-service.component.css']
})
export class DeleteServiceComponent implements OnInit {
  public nameService: any;
  public idService: any;

  constructor(
    public dialogRef: MatDialogRef<DeleteCustomerComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public serviceService: ServiceService) { }

  ngOnInit(): void {
    this.nameService = this.data.data1.name;
    this.idService = this.data.data1.id;
  }

  deleteService(){
    this.serviceService.deleteService(this.idService).subscribe(data =>{
      this.dialogRef.close();
    })
  }

}
