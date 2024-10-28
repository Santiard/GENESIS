import { Component } from '@angular/core';
import { SemesterService } from '../../core/services/semester/semester.service';
import { GroupSemesterService } from '../../core/services/group-semester/group.semester.service';

@Component({
  selector: 'app-polygraph',
  standalone: true,
  imports: [],
  templateUrl: './polygraph.component.html',
  styles: ``,
})
export class PolygraphComponent {
  semesterList: any[] = [];
  semesterStds: any[] = [];

  constructor(
    public semesterService: SemesterService,
    public groupSemesterService: GroupSemesterService,
  ) {}

  ngAfterViewInit() {
    this.semesterService.getNonActiveSemester().subscribe((response: any) => {
      //Ordenar por response.year y response.period año es un numero, y periodo una letra A o B
      //Ejemplo 2024B, 2024A, 2023B, 2023A, 2022B, 2022A
      response.sort((a: any, b: any) => {
        if (a.year > b.year) {
          return -1;
        } else if (a.year < b.year) {
          return 1;
        } else {
          if (a.period == 'B' && b.period == 'A') {
            return -1;
          } else if (a.period == 'A' && b.period == 'B') {
            return 1;
          } else {
            return 0;
          }
        }
      });

      this.semesterList = response;
    });
  }

  onSemesterClick(semester: any) {
    this.groupSemesterService
      .getStdScoresBySemesterNonActive(semester)
      .subscribe((response: any) => {
        this.semesterStds = response;
      });
  }
}
