import {Component, Input, OnInit} from '@angular/core';

export interface IStudent {
  id: number;
  name: string;
  mark: number;
  image: string;
}

@Component({
  selector: 'app-infor-student',
  templateUrl: './infor-student.component.html',
  styleUrls: ['./infor-student.component.css']
})
export class InforStudentComponent implements OnInit {

   @Input()student: IStudent = {
    id: 1,
    name: "cuong",
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
