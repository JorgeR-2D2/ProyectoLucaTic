import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Usuario } from '../Model/Usuario';

@Injectable({
  providedIn: 'root'
})
export class ListadoDescartesService {

  constructor(private http:HttpClient) { }

  Url='http://localhost:8080/restDevuelveListadoDescartes';

  getDescartes(user:Usuario){
  
    return this.http.post<Usuario[]>(this.Url,user);
    
  }
}