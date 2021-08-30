import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListCustomerComponent } from './list-customer/list-customer.component';
import { ListEmployeeComponent } from './list-employee/list-employee.component';
import { ListServiceComponent } from './list-service/list-service.component';
import { ListContractComponent } from './list-contract/list-contract.component';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { CreateServiceComponent } from './create-service/create-service.component';
import { CreateContractComponent } from './create-contract/create-contract.component';
import { CreateContractDetailComponent } from './create-contract-detail/create-contract-detail.component';
import {ReactiveFormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    ListCustomerComponent,
    ListEmployeeComponent,
    ListServiceComponent,
    ListContractComponent,
    CreateCustomerComponent,
    CreateEmployeeComponent,
    CreateServiceComponent,
    CreateContractComponent,
    CreateContractDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
