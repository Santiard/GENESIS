import { Component } from '@angular/core';
import { DashboardButtonComponent } from '../../layouts/buttons/dashboard-button/dashboard-button.component';
import { AcademicInformationComponent } from '../../layouts/tables/academic-information/academic-information.component';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [DashboardButtonComponent, AcademicInformationComponent],
  templateUrl: './dashboard.component.html',
  styles: ``,
})
export class DashboardComponent {
  sections: sectionInfo[] = [
    new sectionInfo('Documentos Pendientes', 'fa-files-o', 'pdgdocuments'),
    new sectionInfo('Matrícula', 'fa-address-book', 'enrollments'),
    new sectionInfo('Plan de Estudio', 'fa-sitemap', 'curriculum'),
    new sectionInfo('Horario', 'fa-calendar', 'schedule'),
    new sectionInfo('Notas', 'fa-check', 'stdscores'),
    new sectionInfo('Poligrafo', 'fa-list', 'polygraph'),
    new sectionInfo('Recibo de Matricula', 'fa-wpforms', 'payment_receipts'),
  ];
}

export class sectionInfo {
  text: string;
  icon: string;
  navTo: string;

  constructor(text: string, icon: string, navTo: string) {
    this.text = text;
    this.icon = icon;
    this.navTo = navTo;
  }
}
