import { Component, input, output } from '@angular/core';
import { CodeToDayPipe } from '../../../core/pipes/code-to-day.pipe';
import { CodeToHourPipe } from '../../../core/pipes/code.to.hour.pipe';

@Component({
  selector: 'app-subject-group-card',
  standalone: true,
  imports: [CodeToDayPipe, CodeToHourPipe],
  templateUrl: './subject-group-card.component.html',
  styleUrl: './subject-group-card.component.css',
})
export class SubjectGroupCardComponent {
  subjectSchedule = input.required<any[]>();
  isEnrolling = input.required<Boolean>();
  enrolled: any = output();
  unenrolled: any = output();

  constructor() {}

  enroll() {
    this.enrolled.emit(this.subjectSchedule()[0]);
  }

  unenroll() {
    this.unenrolled.emit(this.subjectSchedule()[0]);
  }
}
