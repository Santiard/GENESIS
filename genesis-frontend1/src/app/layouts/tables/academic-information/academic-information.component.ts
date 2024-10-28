import { Component } from '@angular/core';
import { SemesterService } from '../../../core/services/semester/semester.service';

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

  constructor(public semesterService: SemesterService) {}

  ngAfterViewInit(): void {
    this.semesterService.getActiveSemester().subscribe((res: any) => {
      this.semester = res.semester ?? 0;
      this.average = res.average ?? 0;
      this.payed = res.paid ?? false;
    });
  }
}
