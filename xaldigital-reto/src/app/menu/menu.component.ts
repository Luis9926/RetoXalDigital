import { Component, OnInit } from '@angular/core';
import { faStackOverflow } from '@fortawesome/free-brands-svg-icons';
import { faPlaneDeparture } from '@fortawesome/free-solid-svg-icons';


@Component({
  selector: 'menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  faPlaneDeparture = faPlaneDeparture;
  faStackOverflow = faStackOverflow;

  constructor() { }

  ngOnInit(): void {
  }

}
