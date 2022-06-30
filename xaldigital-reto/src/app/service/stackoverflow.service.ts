import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StackoverflowService {

  private stackURL = "http://localhost:8080/preguntas";
  constructor(private http: HttpClient) { }

  getPreguntasContestadas(): Observable<any>{
    return this.http.get<any>(`${this.stackURL}/contestadas-y-nocontestadas`);
  }

  getPreguntaMayorRep(): Observable<any>{
    return this.http.get<any>(`${this.stackURL}/mayor-rep`);
  }

  getListaMayorRep(): Observable<any[]>{
    return this.http.get<any[]>(`${this.stackURL}/lista-mayor-rep`);
  }

  getPreguntaMenorNumVistas(): Observable<any[]>{
    return this.http.get<any>(`${this.stackURL}/menor-num-vistas`);
  }

  getPreguntaMasVieja(): Observable<any>{
    return this.http.get<any>(`${this.stackURL}/vieja-actual`);
  }
}
