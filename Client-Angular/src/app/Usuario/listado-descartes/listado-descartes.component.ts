import { Component, OnInit } from '@angular/core';
import { ListadoDescartesService } from 'src/app/UserService/listado-descartes.service';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/Model/Usuario';

@Component({
  selector: 'app-descartes-inicial',
  templateUrl: './listado-descartes.component.html',
  styleUrls: ['./listado-descartes.component.css']
})
export class ListadoDescartesComponent implements OnInit {
  private usuarioPrueba=new Usuario(null,'trollman',null,null,null,null,null);
  
  usuarios:Usuario[];
  constructor(private service:ListadoDescartesService, private router:Router) { }

  ngOnInit() {
    console.log(this.usuarioPrueba.username);
      this.service.getDescartes(this.usuarioPrueba)
      
      .subscribe(data=>{
        this.usuarios=data;
      })
  }

}