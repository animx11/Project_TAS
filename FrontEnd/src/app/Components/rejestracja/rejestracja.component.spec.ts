import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RejestracjaComponent } from './rejestracja.component';

describe('RejestracjaComponent', () => {
  let component: RejestracjaComponent;
  let fixture: ComponentFixture<RejestracjaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RejestracjaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RejestracjaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
