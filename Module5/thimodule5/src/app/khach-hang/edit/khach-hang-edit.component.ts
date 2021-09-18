import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {SoTietKiemService} from "../../service/so-tiet-kiem.service";
import {ActivatedRoute, Router} from "@angular/router";
import {KhachHangService} from "../../service/khach-hang.service";
import {IKhachHang} from "../../interface/KhachHang";

@Component({
  selector: 'app-khach-hang-edit',
  templateUrl: './khach-hang-edit.component.html',
  styleUrls: ['./khach-hang-edit.component.css']
})
export class KhachHangEditComponent implements OnInit {

  public editForm!: FormGroup;
  public id: any;
  khachHangs: IKhachHang[] = [];
  public date = new Date();

  constructor(
    public formBuilder:FormBuilder,
    public soTietKiemService: SoTietKiemService,
    public khachHangService: KhachHangService,
    public router: Router,
    public activatedRoute: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.editForm = this.formBuilder.group({
      'id': [],
      'idCustomer': [''],
      'tenKhachHang': ['', [Validators.required]],
      'ngayMoSo': ['', [Validators.required]],
      'thoiGianBatDauGui': ['', [Validators.required]],
      'kyHan': ['', [Validators.required]],
      'soTienGui': ['', [Validators.required ,Validators.min(9999999)]],
      'laiSuat': ['', [Validators.required]],
      'uuDai': ['', [Validators.required]],
    });

    this.activatedRoute.params.subscribe(data =>{
      this.id = data.id;
      this.soTietKiemService.getById(this.id).subscribe(data =>{
        this.editForm.patchValue(data);
      })
    });

    this.khachHangService.getList().subscribe(data => {
      this.khachHangs = data;
      console.log(data);
    });
  }

  compare(c1:any, c2:any) {
    if (c1 != null && c2 != null) {
      return c1.id === c2.id;
    }
    return false;
  }

  edit() {
    this.soTietKiemService.edit(this.editForm.value, this.id).subscribe(data =>{
      this.router.navigateByUrl('').then(r => {});
    })
  }

}
