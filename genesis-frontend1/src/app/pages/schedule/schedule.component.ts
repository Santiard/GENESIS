import { Component } from '@angular/core';
import { AuthService } from '../../core/services/auth/auth.service';
import { GroupSemesterService } from '../../core/services/group-semester/group.semester.service';

@Component({
  selector: 'app-schedule',
  standalone: true,
  imports: [],
  templateUrl: './schedule.component.html',
})
export class ScheduleComponent {
  scheduleMatrix: scheduleSection[][] = Array.from({ length: 19 }, () =>
    Array(6).fill(''),
  );
  timeSlots: string[] = [
    '6:00 - 6:50',
    '6:50 - 7:40',
    '7:40 - 8:30',
    '8:30 - 9:20',
    '9:20 - 10:10',
    '10:10 - 11:00',
    '11:00 - 11:50',
    '11:50 - 12:40',
    '12:40 - 13:30',
    '13:30 - 14:20',
    '14:20 - 15:10',
    '15:10 - 16:00',
    '16:00 - 16:50',
    '16:50 - 17:40',
    '17:40 - 18:30',
    '18:30 - 19:20',
    '19:20 - 20:10',
    '20:10 - 21:00',
    '21:00 - 21:50',
  ];

  constructor(
    public authService: AuthService,
    public groupSemesterService: GroupSemesterService,
  ) {}

  ngAfterViewInit() {
    this.authService.isLogged();
    this.groupSemesterService.getStdScores().subscribe((res: any) => {
      for (let item in res) {
        this.groupSemesterService
          .getGroupSchedule(res[item].subjectGroup.code)
          .subscribe((res: any) => {
            for (let i in res) {
              for (let j = 0; j < res[i].numberHours; j++) {
                let day: number = res[i].dayOfWeek;
                let time: number = res[i].startTime + j; // Assuming startHour is in 24-hour format
                let code = res[i].group.code;
                let subject = res[i].group.subject.name;
                this.scheduleMatrix[time][day] = { code, subject };
              }
            }
          });
      }
      console.log(this.scheduleMatrix);
    });
  }
}

type scheduleSection = {
  code: string;
  subject: string;
};
