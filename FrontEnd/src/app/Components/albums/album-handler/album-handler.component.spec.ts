import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AlbumHandlerComponent } from './album-handler.component';

describe('AlbumHandlerComponent', () => {
  let component: AlbumHandlerComponent;
  let fixture: ComponentFixture<AlbumHandlerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AlbumHandlerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AlbumHandlerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
