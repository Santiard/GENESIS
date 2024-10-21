import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthService } from '../../core/services/auth/auth.service';

@Component({
  selector: 'app-curriculum',
  standalone: true,
  imports: [],
  templateUrl: './curriculum.component.html',
  styles: ``,
})
export class CurriculumComponent {
  list: any[] = [];
  semesterNumber = 0;

  constructor(public authService: AuthService) {}

  ngOnInit() {
    this.authService.isLogged();

    this.authService.curriculum().subscribe((data: any) => {
      this.list = data;
      this.semesterNumber = Math.max(...this.list.map((item) => item.semester));
    });
  }
}
