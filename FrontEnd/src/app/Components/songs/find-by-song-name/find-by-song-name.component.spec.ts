import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FindBySongNameComponent } from './find-by-song-name.component';

describe('FindBySongNameComponent', () => {
  let component: FindBySongNameComponent;
  let fixture: ComponentFixture<FindBySongNameComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FindBySongNameComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FindBySongNameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
