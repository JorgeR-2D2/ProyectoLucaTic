import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListadoInicialComponent } from './Usuario/listado-inicial/listado-inicial.component';
import { EditarComponent } from './Usuario/editar/editar.component';
import { EliminarComponent } from './Usuario/eliminar/eliminar.component';
import { ListadoContactosComponent } from './Usuario/listado-contactos/listado-contactos.component';
import { ListadoDescartesComponent } from './Usuario/listado-descartes/listado-descartes.component';
import { ListadoMatchesComponent } from './Usuario/listado-matches/listado-matches.component';


const routes: Routes = [
  {path:'listadoInicial', component:ListadoInicialComponent},
  {path:'listadoContactos', component:ListadoContactosComponent},
  {path:'listadoDescartes', component:ListadoDescartesComponent},
  {path:'listadoMatches', component:ListadoMatchesComponent},
  {path: 'editar', component:EditarComponent},
  {path: 'eliminar', component:EliminarComponent}

];
 
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
