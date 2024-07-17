import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailPropertyAdminComponent } from './detail-property-admin.component';

describe('DetailPropertyAdminComponent', () => {
  let component: DetailPropertyAdminComponent;
  let fixture: ComponentFixture<DetailPropertyAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DetailPropertyAdminComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DetailPropertyAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
