import { Component, input, Input } from '@angular/core';
import { sectionInfo } from '../../../pages/dashboard/dashboard.component';
import { NgClass } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard-button',
  standalone: true,
  imports: [NgClass],
  templateUrl: './dashboard-button.component.html',
  styles: ``,
})
export class DashboardButtonComponent {
  item = input(new sectionInfo('', '', ''));

  constructor(private router: Router) {}

  navTo(location: string) {
    this.router.navigate([location]);
  }
}
