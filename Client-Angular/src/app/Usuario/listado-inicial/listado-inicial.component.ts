import { Component, OnInit } from '@angular/core';
import { ListadoInicialService } from 'src/app/UserService/listado-inicial.service';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/Model/Usuario';

@Component({
  selector: 'app-listado-inicial',
  templateUrl: './listado-inicial.component.html',
  styleUrls: ['./listado-inicial.component.css']
})
export class ListadoInicialComponent implements OnInit {
  private usuarioPrueba=new Usuario(null,'trollman',null,null,null,null,null);
  
  usuarios:Usuario[];
  constructor(private service:ListadoInicialService, private router:Router) { }

  ngOnInit() {
    console.log(this.usuarioPrueba.username);
      this.service.getUsuarios(this.usuarioPrueba)
      
      .subscribe(data=>{
        this.usuarios=data;
      })
  }

}
