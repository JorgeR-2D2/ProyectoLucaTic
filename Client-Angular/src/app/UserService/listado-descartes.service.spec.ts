import { TestBed } from '@angular/core/testing';

import { ListadoDescartesService } from './listado-descartes.service';

describe('ListadoDescartesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ListadoDescartesService = TestBed.get(ListadoDescartesService);
    expect(service).toBeTruthy();
  });
});
