import { Injectable } from '@angular/core';
import {IStudent} from "./list-student/list-student.component";

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  student: IStudent[] = [];

  constructor(private studentService: StudentService) { }
}
