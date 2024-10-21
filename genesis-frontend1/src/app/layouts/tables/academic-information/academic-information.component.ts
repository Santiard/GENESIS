import { Component } from '@angular/core';
import { AuthService } from '../../../core/services/auth/auth.service';

@Component({
  selector: 'app-academic-information',
  standalone: true,
  imports: [],
  templateUrl: './academic-information.component.html',
  styles: ``,
})
export class AcademicInformationComponent {
  semester = 0;
  average = 0;
  payed = false;

  constructor(public authService: AuthService) {}

  ngAfterViewInit(): void {
    this.authService.getActiveSemester().subscribe((res: any) => {
      this.semester = res.semester ?? 0;
      this.average = res.average ?? 0;
      this.payed = res.paid ?? false;
    });
  }
}
