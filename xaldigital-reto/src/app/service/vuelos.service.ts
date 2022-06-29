import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VuelosService {
  private vuelosURL = "http://localhost:8080/vuelos";
  constructor(private http:HttpClient) { }

  getVuelosPorDia(): Observable<any[]>{
    return this.http.get<any[]>(`${this.vuelosURL}/vuelos-por-dia`);
  }
  getDiaMasOcupado(): Observable<any>{
    return this.http.get<any>(`${this.vuelosURL}/dia-mas-ocupado`);
  }

  getVuelosPorAerolinea(): Observable<any[]>{
    return this.http.get<any[]>(`${this.vuelosURL}/vuelos-por-aerolinea`);
  }
  getAerolineaMasOcupada(): Observable<any>{
    return this.http.get<any[]>(`${this.vuelosURL}/aerolinea-mas-ocupada`);
  }

  getAerolineasMas2Vuelos(): Observable<any[]>{
    return this.http.get<any[]>(`${this.vuelosURL}/aerolinea-con-mas-de-2-vuelos`);
  }

  getVuelosPorAeropuerto(): Observable<any[]>{
    return this.http.get<any[]>(`${this.vuelosURL}/movimientos-por-aeropuerto`);
  }
  getAeropuertoMasOcupado(): Observable<any>{
    return this.http.get<any[]>(`${this.vuelosURL}/aeropuerto-mas-ocupado`);
  }
}
