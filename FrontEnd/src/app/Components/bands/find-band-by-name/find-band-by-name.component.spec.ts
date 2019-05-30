import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FindBandByNameComponent } from './find-band-by-name.component';

describe('FindBandByNameComponent', () => {
  let component: FindBandByNameComponent;
  let fixture: ComponentFixture<FindBandByNameComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FindBandByNameComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FindBandByNameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
