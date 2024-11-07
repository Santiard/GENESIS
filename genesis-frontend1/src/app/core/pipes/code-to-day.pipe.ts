import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'codeToDay',
  standalone: true,
})
export class CodeToDayPipe implements PipeTransform {
  transform(value: number): string {
    let day = 'unknown';
    switch (value) {
      case 0:
        day = 'Lunes';
        break;
      case 1:
        day = 'Martes';
        break;
      case 2:
        day = 'Miercoles';
        break;
      case 3:
        day = 'Jueves';
        break;
      case 4:
        day = 'Viernes';
        break;
      case 5:
        day = 'Sabado';
        break;
      case 6:
        day = 'Domingo';
        break;
    }

    return day;
  }
}
