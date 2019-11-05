import { Component, OnInit } from '@angular/core';
import { ListadoMatchesService } from 'src/app/UserService/listado-matches.service';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/Model/Usuario';

@Component({
  selector: 'app-matches-inicial',
  templateUrl: './listado-matches.component.html',
  styleUrls: ['./listado-matches.component.css']
})
export class ListadoMatchesComponent implements OnInit {
  private usuarioPrueba=new Usuario(null,'trollman',null,null,null,null,null);
  
  usuarios:Usuario[];
  constructor(private service:ListadoMatchesService, private router:Router) { }

  ngOnInit() {
    console.log(this.usuarioPrueba.username);
      this.service.getMatches(this.usuarioPrueba)
      
      .subscribe(data=>{
        this.usuarios=data;
      })
  }

}