import { Component } from '@angular/core';
import { SemesterService } from '../../core/services/semester/semester.service';
import { GroupSemesterService } from '../../core/services/group-semester/group.semester.service';
import { SubjectGroupCardComponent } from '../../layouts/cards/subject-group-card/subject-group-card.component';

@Component({
  selector: 'app-enrollments',
  standalone: true,
  imports: [SubjectGroupCardComponent],
  templateUrl: './enrollments.component.html',
  styleUrl: './enrollments.component.css',
})
export class EnrollmentsComponent {
  semester: any = null;
  userSubjects: any[] = [];
  subjects: any[] = [];
  constructor(
    private semesterService: SemesterService,
    private groupSemesterService: GroupSemesterService,
  ) {}

  ngOnInit() {
    this.getSubjects();
  }

  getSubjects() {
    this.userSubjects = [];
    this.subjects = [];
    this.semesterService.getActiveSemester().subscribe((semester) => {
      this.semester = semester;
    });

    this.groupSemesterService.getStdScores().subscribe((res: any) => {
      for (let subject in res) {
        this.groupSemesterService
          .getGroupSchedule(res[subject].subjectGroup.code)
          .subscribe((res: any) => {
            for (let value of res) {
              let found = this.userSubjects.findIndex(
                (userSubject) => userSubject[0].group.code === value.group.code,
              );
              if (found === -1) {
                let userSubject = [];
                userSubject.push(value);
                this.userSubjects.push(userSubject);
              } else {
                this.userSubjects[found].push(value);
              }
            }
          });
      }

      this.groupSemesterService.getAllSchedules().subscribe((res: any) => {
        for (let subject of res) {
          let found1 = this.userSubjects.find((userSubject) => {
            for (let value of userSubject) {
              if (value.group.subject.id === subject.group.subject.id) {
                return true;
              }
            }

            return false;
          });
          if (found1 === undefined) {
            let found = this.subjects.findIndex(
              (userSubject) => userSubject[0].group.code === subject.group.code,
            );
            if (found === -1) {
              let userSubject = [];
              userSubject.push(subject);
              this.subjects.push(userSubject);
            } else {
              this.subjects[found].push(subject);
            }
          }
        }
      });
    });
  }

  enroll(subject: any) {
    if (this.semester.availableCredits < subject.group.subject.credits) {
      alert('You do not have enough credits to enroll in this subject');
      return;
    }

    let conflict = false;
    for (let userSubject of this.userSubjects) {
      let leave = false;
      for (let value of userSubject) {
        const endTime = value.startTime + value.numberHours - 1;
        console.log('Schedule dayOfWeek', value.dayOfWeek);
        console.log('Schedule startTimes', value.startTime);
        console.log('Schedule endTimes', endTime);
        console.log();
        console.log('Subject dayOfWeek', subject.dayOfWeek);
        console.log('Subject startTimes', subject.startTime);
        console.log('+++++++++++++++++++++++++++');

        if (
          value.dayOfWeek === subject.dayOfWeek &&
          subject.startTime >= value.startTime &&
          subject.startTime <= endTime
        ) {
          conflict = true;
          leave = true;
          break;
        }
      }
      if (leave) break;
    }

    if (conflict) {
      alert('You have a conflict with this subject check your schedule');
      return;
    }

    this.groupSemesterService
      .enroll(subject.group, this.semester)
      .subscribe(() => {
        this.getSubjects();
      });
  }

  unenroll(subject: any) {
    this.groupSemesterService
      .unenroll(subject.group, this.semester)
      .subscribe(() => {
        this.getSubjects();
      });
  }
}
