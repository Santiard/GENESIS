import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'codeToHour',
  standalone: true,
})
export class CodeToHourPipe implements PipeTransform {
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
  transform(value: number): string {
    return this.timeSlots[value];
  }
}
