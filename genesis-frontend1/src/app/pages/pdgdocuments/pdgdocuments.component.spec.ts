import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PdgdocumentsComponent } from './pdgdocuments.component';

describe('PdgdocumentsComponent', () => {
  let component: PdgdocumentsComponent;
  let fixture: ComponentFixture<PdgdocumentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PdgdocumentsComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(PdgdocumentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
