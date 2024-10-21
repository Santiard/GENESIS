import { Component } from '@angular/core';
import { AuthService } from '../../core/services/auth/auth.service';
import { CurrencyFormatPipe } from '../../core/pipes/currency.format.pipe';

@Component({
  selector: 'app-payment-receipts',
  standalone: true,
  imports: [CurrencyFormatPipe],
  templateUrl: './payment-receipts.component.html',
  styles: ``,
})
export class PaymentReceiptsComponent {
  preOrdinal: any = null;
  ordinal: any = null;
  postOrdinal: any = null;
  semester: any = null

  constructor(public authService: AuthService) {}

  ngAfterViewInit() {
    this.authService.getActiveSemester().subscribe((response: any) => {
      const porcentage = 0.1;
      this.ordinal = response.semesterValue
      this.preOrdinal = response.semesterValue - (response.semesterValue * porcentage)
      this.postOrdinal = response.semesterValue + (response.semesterValue * porcentage)
      this.semester = response;
    });
  }

  onPayButtonClicked() {
    this.authService.paySemester(this.semester).subscribe();
    this.semester.paid = true;
  }
}
