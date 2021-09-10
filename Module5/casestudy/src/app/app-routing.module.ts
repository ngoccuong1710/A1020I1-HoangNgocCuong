import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {HomeComponent} from "./components/home/home.component";
import {ListCustomerComponent} from "./components/customer/list-customer/list-customer.component";
import {ListEmployeeComponent} from "./components/employee/list-employee/list-employee.component";
import {ListServiceComponent} from "./components/service/list-service/list-service.component";
import {ListContractComponent} from "./components/contract/list-contract/list-contract.component";
import {ListContractDetailComponent} from "./components/contract-detail/list-contract-detail/list-contract-detail.component";
import {PageNotFoundComponent} from "./components/page-not-found/page-not-found.component";
import {CreateCustomerComponent} from "./components/customer/create-customer/create-customer.component";
import {EditCustomerComponent} from "./components/customer/edit-customer/edit-customer.component";


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'customer-list', component: ListCustomerComponent},
  {path: 'customer-create', component: CreateCustomerComponent},
  {path: 'customer-edit/:id', component: EditCustomerComponent},
  {path: 'employee-list', component: ListEmployeeComponent},
  {path: 'service-list', component: ListServiceComponent},
  {path: 'contract-list', component: ListContractComponent},
  {path: 'contract-detail-list', component: ListContractDetailComponent},
  {path: '**', component: PageNotFoundComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
