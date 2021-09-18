import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { KhachHangComponent } from './khach-hang.component';
import { KhachHangEditComponent } from './edit/khach-hang-edit.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import { DeleteKhachHangComponent } from './delete/delete-khach-hang.component';
import {MatDialogModule} from "@angular/material/dialog";
import {NgxPaginationModule} from "ngx-pagination";
import {MatDatepickerModule} from "@angular/material/datepicker";

@NgModule({
  declarations: [
    KhachHangComponent,
    KhachHangEditComponent,
    DeleteKhachHangComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RouterModule,
    MatDialogModule,
    FormsModule,
    NgxPaginationModule,
    MatDatepickerModule,
  ]
})
export class KhachHangModule { }
