import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {KhachHangComponent} from "./khach-hang/khach-hang.component";
import {KhachHangEditComponent} from "./khach-hang/edit/khach-hang-edit.component";

const routes: Routes = [
  {path: '', component: KhachHangComponent},
  {path: 'edit/:id', component: KhachHangEditComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
