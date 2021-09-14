import { Component, OnInit } from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {ServiceService} from "../../../services/service.service";
import {IService} from "../../../models/service";
import {DeleteServiceComponent} from "../delete-service/delete-service.component";

@Component({
  selector: 'app-list-service',
  templateUrl: './list-service.component.html',
  styleUrls: ['./list-service.component.css']
})
export class ListServiceComponent implements OnInit {

  public services!: IService;
  keyword!: '';
  p: number = 1;

  constructor(public serviceService: ServiceService, public dialog: MatDialog) { }

  ngOnInit(): void {
    this.serviceService.getAllServices().subscribe(data => {
      this.services = data;
      console.log(this.services);
    });
  }

  openDialog(idService: any): void {
    this.serviceService.getServiceById(idService).subscribe(dataService =>{
      const dialogRef = this.dialog.open(DeleteServiceComponent, {
        width: '500px',
        data: {data1: dataService},
        disableClose: true
      });

      dialogRef.afterClosed().subscribe(result => {
        this.ngOnInit();
      });
    });
  }

}
