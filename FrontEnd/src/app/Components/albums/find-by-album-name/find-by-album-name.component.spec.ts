import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FindByAlbumNameComponent } from './find-by-album-name.component';

describe('FindByAlbumNameComponent', () => {
  let component: FindByAlbumNameComponent;
  let fixture: ComponentFixture<FindByAlbumNameComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FindByAlbumNameComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FindByAlbumNameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
