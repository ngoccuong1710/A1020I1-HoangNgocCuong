import { Component, OnInit } from '@angular/core';
import {IContract} from "../../../models/contract";
import {MatDialog} from "@angular/material/dialog";
import {ContractService} from "../../../services/contract.service";
import {DeleteServiceComponent} from "../../service/delete-service/delete-service.component";

@Component({
  selector: 'app-list-contract',
  templateUrl: './list-contract.component.html',
  styleUrls: ['./list-contract.component.css']
})
export class ListContractComponent implements OnInit {

  public contracts!: IContract;
  keyword!: '';
  p: number = 1;

  constructor(public contractService: ContractService, public dialog: MatDialog) { }

  ngOnInit(): void {
    this.contractService.getAllContracts().subscribe(data => {
      this.contracts = data;
      console.log(this.contracts);
    });
  }

  openDialog(idContract: any): void {
    this.contractService.getContractById(idContract).subscribe(dataContract =>{
      const dialogRef = this.dialog.open(DeleteServiceComponent, {
        width: '500px',
        data: {data1: dataContract},
        disableClose: true
      });

      dialogRef.afterClosed().subscribe(result => {
        this.ngOnInit();
      });
    });
  }

}
