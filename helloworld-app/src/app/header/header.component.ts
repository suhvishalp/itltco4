import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public companyName: string = 'LTI'

  public imageUrl: string = '/assets/ltilogo.png';

  constructor() { 

    setTimeout(() => {
      this.companyName = 'Larsen & Turbo Infotech'
      this.imageUrl = '/assets/litlogo2.png';
    }, 8000);

  }

  ngOnInit(): void {
  }

}
