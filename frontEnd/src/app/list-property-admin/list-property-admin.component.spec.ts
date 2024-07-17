import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListPropertyAdminComponent } from './list-property-admin.component';

describe('ListPropertyAdminComponent', () => {
  let component: ListPropertyAdminComponent;
  let fixture: ComponentFixture<ListPropertyAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ListPropertyAdminComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListPropertyAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
