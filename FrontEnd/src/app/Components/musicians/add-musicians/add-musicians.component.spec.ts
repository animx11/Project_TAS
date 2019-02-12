import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddMusiciansComponent } from './add-musicians.component';

describe('AddMusiciansComponent', () => {
  let component: AddMusiciansComponent;
  let fixture: ComponentFixture<AddMusiciansComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddMusiciansComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddMusiciansComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
