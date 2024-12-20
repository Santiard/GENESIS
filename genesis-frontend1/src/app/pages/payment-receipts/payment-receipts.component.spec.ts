import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaymentReceiptsComponent } from './payment-receipts.component';

describe('PaymentReceiptsComponent', () => {
  let component: PaymentReceiptsComponent;
  let fixture: ComponentFixture<PaymentReceiptsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PaymentReceiptsComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(PaymentReceiptsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
