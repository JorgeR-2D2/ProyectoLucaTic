import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListadoDescartesComponent } from './listado-descartes.component';

describe('ListadoDescartesComponent', () => {
  let component: ListadoDescartesComponent;
  let fixture: ComponentFixture<ListadoDescartesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListadoDescartesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListadoDescartesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
