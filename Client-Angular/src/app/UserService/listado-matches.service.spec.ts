import { TestBed } from '@angular/core/testing';

import { ListadoMatchesService } from './listado-matches.service';

describe('ListadoMatchesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ListadoMatchesService = TestBed.get(ListadoMatchesService);
    expect(service).toBeTruthy();
  });
});
