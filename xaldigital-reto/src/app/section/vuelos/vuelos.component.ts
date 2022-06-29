import { Component, OnInit } from '@angular/core';
import { VuelosService } from 'src/app/service/vuelos.service';

@Component({
  selector: 'app-vuelos',
  templateUrl: './vuelos.component.html',
  styleUrls: ['./vuelos.component.css']
})
export class VuelosComponent implements OnInit {

  single: any[];

  view: [number,number] = [600, 300];
  view2: [number,number] = [800, 400];

  gradient: boolean = true;
  showLegend: boolean = true;
  showLabels: boolean = true;
  isDoughnut: boolean = false;
  label: string = "Vuelos en total";
  labelAerolinea: string = "Movimientos en total";
  totalDias: number;
  diaOcupado: any;
  aerolineaOcupada: any;
  aeropuertoOcupado: any;

  showXAxis: boolean = true;
  showYAxis: boolean = true;
  showXAxisLabel: boolean = true;
  yAxisLabel: string = 'Fechas';
  showYAxisLabel: boolean = true;
  xAxisLabel: string = 'Movimientos';

  yAxisLabel2: string = 'Aeropuerto';
  xAxisLabel2: string = 'Movimientos';


  vuelosPorAerolinea: any;
  aerolineaMas2Vuelos: any;
  vuelosPorAeropuerto: any;


  constructor(private vueloService: VuelosService) {
    this.diaOcupado = "";
    this.single = [];
    this.totalDias = 0;
    this.vuelosPorAerolinea = [];
    this.vuelosPorAeropuerto = [];

   }

  ngOnInit(): void {
    this.initInfoPorDia();
    this.initInfoPorAerolinea();
    this.initInfoPorAeropuerto();
  }

  initInfoPorDia(){
    this.vueloService.getDiaMasOcupado().subscribe(data =>{
      this.diaOcupado = data;
      console.log(data);
    });
    this.vueloService.getVuelosPorDia().subscribe(data => {
      data.forEach(el =>{
        this.single.push({
          "name" : el.dia,
          "value" : el.vuelos
        });
        this.totalDias += el.vuelos;
      });
      console.log(this.totalDias);
    });
  }

  initInfoPorAerolinea(){
    this.vueloService.getAerolineasMas2Vuelos().subscribe(data =>{
      this.aerolineaMas2Vuelos = data;
      console.log(data);
    });
    this.vueloService.getAerolineaMasOcupada().subscribe(data =>{
      this.aerolineaOcupada = data;
      console.log(data);
    });
    this.vueloService.getVuelosPorAerolinea().subscribe(data => {
      data.forEach(el =>{
        this.vuelosPorAerolinea.push({
          "name" : el.nombre_aerolinea,
          "value" : el.vuelos
        });
      });
    });
  }

  initInfoPorAeropuerto(){
    this.vueloService.getAeropuertoMasOcupado().subscribe(data =>{
      this.aeropuertoOcupado = data;
    });
    this.vueloService.getVuelosPorAeropuerto().subscribe(data =>{
      data.forEach(el =>{
        this.vuelosPorAeropuerto.push({
          "name" : el.nombre_aeropuerto,
          "value" : el.movimientos
        });
      });
    });
  }


}
