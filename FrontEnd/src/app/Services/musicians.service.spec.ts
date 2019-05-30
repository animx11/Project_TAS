import { TestBed, inject } from '@angular/core/testing';

import { MusiciansService } from './musicians.service';

describe('MusiciansService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MusiciansService]
    });
  });

  it('should be created', inject([MusiciansService], (service: MusiciansService) => {
    expect(service).toBeTruthy();
  }));
});
