import { Component, OnInit } from '@angular/core';

export interface IStudent {
  id: number;
  name: string;
  mark: number;
  image: string;
}

@Component({
  selector: 'app-student-infor',
  templateUrl: './student-infor.component.html',
  styleUrls: ['./student-infor.component.css']
})
export class StudentInforComponent implements OnInit {

  student: IStudent = {
    id: 1,
    name: "Cuong",
    mark: 0,
    image: 'https://image.flaticon.com/icons/png/512/147/147144.png'
  }

  constructor() { }

  ngOnInit(): void {
  }

  getMark(value: any){
    this.student.mark = value
  }

}
