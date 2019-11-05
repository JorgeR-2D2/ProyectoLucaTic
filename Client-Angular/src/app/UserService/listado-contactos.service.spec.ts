import { TestBed } from '@angular/core/testing';

import { ListadoContactosService } from './listado-contactos.service';

describe('ListadoContactosService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ListadoContactosService = TestBed.get(ListadoContactosService);
    expect(service).toBeTruthy();
  });
});
