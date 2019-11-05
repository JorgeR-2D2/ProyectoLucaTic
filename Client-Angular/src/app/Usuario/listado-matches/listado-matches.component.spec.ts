import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListadoMatchesComponent } from './listado-matches.component';

describe('ListadoMatchesComponent', () => {
  let component: ListadoMatchesComponent;
  let fixture: ComponentFixture<ListadoMatchesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListadoMatchesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListadoMatchesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
