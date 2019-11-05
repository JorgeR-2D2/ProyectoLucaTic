import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ProyectoLucatinderClient';

  constructor(private router:Router){}

  listadoInicial(){
    this.router.navigate(["listadoInicial"])
  }
  listadoContactos(){
    this.router.navigate(["listadoContactos"])
  }
  listadoDescartes(){
    this.router.navigate(["listadoDescartes"])
  }
  listadoMatches(){
    this.router.navigate(["listadoMatches"])
  }
  editar(){
    this.router.navigate(["editar"])
  }
  eliminar(){
    this.router.navigate(["eliminar"])
  }
}
