import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ung-dung-binh-chon';

  onRateChange(value: number) {
    console.log(value);
  }
}
