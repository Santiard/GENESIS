import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubjectGroupCardComponent } from './subject-group-card.component';

describe('SubjectGroupCardComponent', () => {
  let component: SubjectGroupCardComponent;
  let fixture: ComponentFixture<SubjectGroupCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SubjectGroupCardComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SubjectGroupCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
