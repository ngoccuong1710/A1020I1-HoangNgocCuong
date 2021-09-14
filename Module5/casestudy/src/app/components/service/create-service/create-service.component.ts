import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {ServiceService} from "../../../services/service.service";

interface RentType {
  value: string;
  viewValue: string;
}

interface ServiceType {
  value: string;
  viewValue: string;
}

interface StandardRoom {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-create-service',
  templateUrl: './create-service.component.html',
  styleUrls: ['./create-service.component.css']
})
export class CreateServiceComponent implements OnInit {

  public serviceCreateForm!: FormGroup;

  constructor(
    public formBuilder:FormBuilder,
    public serviceService: ServiceService,
    public router: Router) { }

  ngOnInit(): void {
    this.serviceCreateForm = this.formBuilder.group({
      'id': [],
      'idService': [''],
      'name': ['', [Validators.required]],
      'area': ['', [Validators.required]],
      'cost': ['', [Validators.required]],
      'maxPeople': ['', [Validators.required]],
      'rentType': ['', [Validators.required]],
      'serviceType': ['', [Validators.required]],
      'standardRoom': ['', [Validators.required]],
      'descriptionOtherConvenience': ['', [Validators.required]],
      'poolArea': ['', [Validators.required]],
      'numOfFloors': ['', [Validators.required]],
    })
  }

  addNewService(){
    this.serviceCreateForm.value.idService = "DV-" + Math.floor(Math.random() * 10000);
    this.serviceService.addNewService(this.serviceCreateForm.value).subscribe(data => {
      this.router.navigateByUrl('service-list').then(r => {});
    })
  }

  rentTypes: RentType[] = [
    {value: 'Năm', viewValue: 'Năm'},
    {value: 'Tháng', viewValue: 'Tháng'},
    {value: 'Ngày', viewValue: 'Ngày'},
    {value: 'Giờ', viewValue: 'Giờ'},
  ];

  serviceTypes: ServiceType[] = [
    {value: 'Villa', viewValue: 'Villa'},
    {value: 'House', viewValue: 'House'},
    {value: 'Room', viewValue: 'Room'},
  ];

  standardRooms: StandardRoom[] = [
    {value: 'Vip', viewValue: 'Vip'},
    {value: 'Normal', viewValue: 'Normal'},
  ];
}
