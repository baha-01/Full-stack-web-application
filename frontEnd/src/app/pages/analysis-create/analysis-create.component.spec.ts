import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnalysisCreateComponent } from './analysis-create.component';

describe('AnalysisCreateComponent', () => {
  let component: AnalysisCreateComponent;
  let fixture: ComponentFixture<AnalysisCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AnalysisCreateComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AnalysisCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
