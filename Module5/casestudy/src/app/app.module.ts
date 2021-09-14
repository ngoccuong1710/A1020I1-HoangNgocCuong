import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListCustomerComponent } from './components/customer/list-customer/list-customer.component';
import { ListEmployeeComponent } from './components/employee/list-employee/list-employee.component';
import { ListServiceComponent } from './components/service/list-service/list-service.component';
import { ListContractComponent } from './components/contract/list-contract/list-contract.component';
import { CreateCustomerComponent } from './components/customer/create-customer/create-customer.component';
import { CreateEmployeeComponent } from './components/employee/create-employee/create-employee.component';
import { CreateServiceComponent } from './components/service/create-service/create-service.component';
import { CreateContractComponent } from './components/contract/create-contract/create-contract.component';
import { CreateContractDetailComponent } from './components/contract-detail/create-contract-detail/create-contract-detail.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { HomeComponent } from './components/home/home.component';
import { ListContractDetailComponent } from './components/contract-detail/list-contract-detail/list-contract-detail.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import {HttpClientModule} from "@angular/common/http";
import {Ng2SearchPipeModule} from "ng2-search-filter";
import {NgxPaginationModule} from "ngx-pagination";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatSelectModule} from "@angular/material/select";
import {MatRadioModule} from "@angular/material/radio";
import { DeleteCustomerComponent } from './components/customer/delete-customer/delete-customer.component';
import {MatDialogModule} from "@angular/material/dialog";
import { EditCustomerComponent } from './components/customer/edit-customer/edit-customer.component';
import { EditEmployeeComponent } from './components/employee/edit-employee/edit-employee.component';
import { DeleteEmployeeComponent } from './components/employee/delete-employee/delete-employee.component';
import {SearchPipe} from "./search.pipe";
import { DeleteServiceComponent } from './components/service/delete-service/delete-service.component';
import { EditServiceComponent } from './components/service/edit-service/edit-service.component';

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
    CreateContractDetailComponent,
    HomeComponent,
    ListContractDetailComponent,
    PageNotFoundComponent,
    DeleteCustomerComponent,
    EditCustomerComponent,
    EditEmployeeComponent,
    DeleteEmployeeComponent,
    SearchPipe,
    DeleteServiceComponent,
    EditServiceComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    Ng2SearchPipeModule,
    NgxPaginationModule,
    BrowserAnimationsModule,
    MatSelectModule,
    MatRadioModule,
    MatDialogModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents:[DeleteCustomerComponent]
})
export class AppModule { }
