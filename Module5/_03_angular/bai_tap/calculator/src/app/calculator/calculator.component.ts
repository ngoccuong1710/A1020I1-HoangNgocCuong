import { Component, OnInit } from '@angular/core';

export interface ICalculator {
  output: number;
  first: number;
  second: number;
  operator: string;
}

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {

  calculator: ICalculator = {
    output: 0,
    first: 0,
    second: 0,
    operator: '+'
}

  onFirstChange(value: any) {
    this.calculator.first = Number(value);
  }
  onSecondChange(value: any) {
    this.calculator.second = Number(value);
  }
  onSelectChange(value: any) {
    this.calculator.operator = value;
  }
  calculate() {
    switch (this.calculator.operator) {
      case '+':
        this.calculator.output = this.calculator.first + this.calculator.second;
        break;
      case '-':
        this.calculator.output = this.calculator.first - this.calculator.second;
        break;
      case '*':
        this.calculator.output = this.calculator.first * this.calculator.second;
        break;
      case '/':
        this.calculator.output = this.calculator.first / this.calculator.second;
        break;
    }
  }

  constructor() { }

  ngOnInit(): void {
  }

}
