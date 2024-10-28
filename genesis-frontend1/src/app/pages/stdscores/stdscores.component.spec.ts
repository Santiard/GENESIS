import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StdscoresComponent } from './stdscores.component';

describe('StdscoresComponent', () => {
  let component: StdscoresComponent;
  let fixture: ComponentFixture<StdscoresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StdscoresComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(StdscoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
