import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteBandComponent } from './delete-band.component';

describe('DeleteBandComponent', () => {
  let component: DeleteBandComponent;
  let fixture: ComponentFixture<DeleteBandComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeleteBandComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteBandComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
