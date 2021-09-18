import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {SoTietKiemService} from "../../service/so-tiet-kiem.service";

@Component({
  selector: 'app-delete-khach-hang',
  templateUrl: './delete-khach-hang.component.html',
  styleUrls: ['./delete-khach-hang.component.css']
})
export class DeleteKhachHangComponent implements OnInit {
  public id: any;
  constructor(
    public dialogRef: MatDialogRef<DeleteKhachHangComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public soTietKiemService: SoTietKiemService
  ) { }

  ngOnInit(): void {
    this.id = this.data.data1.id;
  }

  delete(){
    this.soTietKiemService.delete(this.id).subscribe(data =>{
      this.dialogRef.close();
    })
  }

}
