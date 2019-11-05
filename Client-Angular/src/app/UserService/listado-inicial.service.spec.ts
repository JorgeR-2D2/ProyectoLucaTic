import { TestBed } from '@angular/core/testing';

import { ListadoInicialService } from './listado-inicial.service';

describe('ListadoInicialService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ListadoInicialService = TestBed.get(ListadoInicialService);
    expect(service).toBeTruthy();
  });
});
