import { Component, OnInit } from '@angular/core';

export interface IStudent {
  id: number;
  name: string;
  mark: number;
  image: string;
}

@Component({
  selector: 'app-list-student',
  templateUrl: './list-student.component.html',
  styleUrls: ['./list-student.component.css']
})
export class ListStudentComponent implements OnInit {


  students: IStudent[] = [
    {
      id: 1,
      name: "Cuong",
      mark: 5,
      image: ''
    },
    {
      id: 2,
      name: "Trung",
      mark: 7,
      image: ''
    },
    {
      id: 3,
      name: "Thanh",
      mark: 3,
      image: ''
    },
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
