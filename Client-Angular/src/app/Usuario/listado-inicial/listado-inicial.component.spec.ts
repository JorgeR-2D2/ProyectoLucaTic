import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListadoInicialComponent } from './listado-inicial.component';

describe('ListadoInicialComponent', () => {
  let component: ListadoInicialComponent;
  let fixture: ComponentFixture<ListadoInicialComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListadoInicialComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListadoInicialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
