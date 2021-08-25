import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pick-color',
  templateUrl: './pick-color.component.html',
  styleUrls: ['./pick-color.component.css']
})
export class PickColorComponent implements OnInit {
  background = '#00e067';
  constructor() { }

  ngOnInit(): void {
  }

  onChange(value: any) {
    this.background = value;
  }

}
