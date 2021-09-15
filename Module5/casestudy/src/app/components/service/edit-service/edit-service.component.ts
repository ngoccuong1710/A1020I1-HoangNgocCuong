import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
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
  selector: 'app-edit-service',
  templateUrl: './edit-service.component.html',
  styleUrls: ['./edit-service.component.css']
})
export class EditServiceComponent implements OnInit {

  public serviceEditForm!: FormGroup;
  public idService: any;


  constructor(public formBuilder:FormBuilder,
              public serviceService: ServiceService,
              public router: Router,
              public activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.serviceEditForm = this.formBuilder.group({
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
    });

    this.activatedRoute.params.subscribe(data =>{
      this.idService = data.id;
      this.serviceService.getServiceById(this.idService).subscribe(data =>{
        this.serviceEditForm.patchValue(data);
      })
    })
  }

  editService() {
    this.serviceService.editService(this.serviceEditForm.value, this.idService).subscribe(data =>{
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
