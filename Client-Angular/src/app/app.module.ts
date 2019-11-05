import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListadoInicialComponent } from './Usuario/listado-inicial/listado-inicial.component';
import { EditarComponent } from './Usuario/editar/editar.component';
import { EliminarComponent } from './Usuario/eliminar/eliminar.component';
import {ListadoInicialService} from '../app/UserService/listado-inicial.service';
import {HttpClientModule} from '@angular/common/http';
import { ListadoContactosComponent } from './Usuario/listado-contactos/listado-contactos.component';
import { ListadoContactosService } from './UserService/listado-contactos.service';
import { ListadoDescartesComponent } from './Usuario/listado-descartes/listado-descartes.component';
import { ListadoDescartesService } from './UserService/listado-descartes.service';
import { ListadoMatchesComponent } from './Usuario/listado-matches/listado-matches.component';
import { ListadoMatchesService } from './UserService/listado-matches.service';




@NgModule({
  declarations: [
    AppComponent,
    ListadoInicialComponent,
    EditarComponent,
    EliminarComponent,
    ListadoContactosComponent,
    ListadoDescartesComponent,
    ListadoMatchesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [ListadoInicialService,ListadoContactosService,ListadoDescartesService,ListadoMatchesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
