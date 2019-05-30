import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SongsAddComponent } from './songs-add.component';

describe('SongsAddComponent', () => {
  let component: SongsAddComponent;
  let fixture: ComponentFixture<SongsAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SongsAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SongsAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
