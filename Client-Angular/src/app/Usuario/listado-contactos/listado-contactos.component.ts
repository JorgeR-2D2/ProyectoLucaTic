import { Component, OnInit } from '@angular/core';
import { ListadoContactosService } from 'src/app/UserService/listado-contactos.service';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/Model/Usuario';

@Component({
  selector: 'app-contactos-inicial',
  templateUrl: './listado-contactos.component.html',
  styleUrls: ['./listado-contactos.component.css']
})
export class ListadoContactosComponent implements OnInit {
  private usuarioPrueba=new Usuario(null,'trollman',null,null,null,null,null);
  
  usuarios:Usuario[];
  constructor(private service:ListadoContactosService, private router:Router) { }

  ngOnInit() {
    console.log(this.usuarioPrueba.username);
      this.service.getContactos(this.usuarioPrueba)
      
      .subscribe(data=>{
        this.usuarios=data;
      })
  }

}
