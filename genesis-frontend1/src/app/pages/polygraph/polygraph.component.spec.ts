import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PolygraphComponent } from './polygraph.component';

describe('PolygraphComponent', () => {
  let component: PolygraphComponent;
  let fixture: ComponentFixture<PolygraphComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PolygraphComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PolygraphComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
