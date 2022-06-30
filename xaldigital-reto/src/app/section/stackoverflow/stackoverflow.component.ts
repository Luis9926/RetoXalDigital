import { Component, OnInit } from '@angular/core';
import { StackoverflowService } from 'src/app/service/stackoverflow.service';

@Component({
  selector: 'app-stackoverflow',
  templateUrl: './stackoverflow.component.html',
  styleUrls: ['./stackoverflow.component.css']
})
export class StackoverflowComponent implements OnInit {

  listaMayorRep: any;
  yAxisLabel2: string = 'Usuario';
  xAxisLabel2: string = 'Reputacion';
  preguntaMayorRep:any;

  contestadasNoContestadas: any;
  view: [number,number] = [600, 300];
  gradient: boolean = true;
  showXAxis: boolean = true;
  showYAxis: boolean = true;
  showXAxisLabel: boolean = true;
  yAxisLabel: string = 'Tipo';
  showYAxisLabel: boolean = true;
  xAxisLabel: string = 'Cantidad';

  preguntaMenorNumVistas: any;
  preguntaMasVieja: any;
  preguntaMasNueva: any;

  constructor(private service:StackoverflowService) {
    this.contestadasNoContestadas = [];
    this.listaMayorRep = [];
    this.preguntaMayorRep = null;
    this.preguntaMasVieja = null;
  }

  async ngOnInit() {
    await this.initInfo();
  }

 async initInfo(){
   await this.service.getPreguntasContestadas().subscribe(data => {
      console.log("Aqui",data.contestadas);

      this.contestadasNoContestadas.push({
        'name': "Contestadas",
        'value': data.contestadas
      });
      this.contestadasNoContestadas.push({
        'name': "No Contestadas",
        'value': data.noContestadas
      });
    });

    await this.service.getPreguntaMayorRep().subscribe(data => {
      this.preguntaMayorRep = data;
    });

    await this.service.getListaMayorRep().subscribe(data => {
      data.forEach(el =>{
        this.listaMayorRep.push({
          "name" : el.owner.display_name,
          "value": el.owner.reputation
        });

      });
    });

    await this.service.getPreguntaMenorNumVistas().subscribe(data => {
      this.preguntaMenorNumVistas = data;
    });

    await this.service.getPreguntaMasVieja().subscribe(data => {
      this.preguntaMasVieja = data.preguntaVieja;
      this.preguntaMasNueva = data.preguntaNueva;

    });

  }
}
