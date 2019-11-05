import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListadoContactosComponent } from './listado-contactos.component';

describe('ListadoContactosComponent', () => {
  let component: ListadoContactosComponent;
  let fixture: ComponentFixture<ListadoContactosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListadoContactosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListadoContactosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
