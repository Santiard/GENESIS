import { Injectable } from '@angular/core';
import { AuthService } from '../auth/auth.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class SemesterService {
  private semester = 'http://localhost:8080/semester';

  constructor(
    private authService: AuthService,
    private http: HttpClient,
    private router: Router,
  ) {}

  getSemesters() {
    return this.http.get(`${this.semester}/code`, {
      params: { code: this.authService.account.code },
    });
  }

  getActiveSemester() {
    return this.http.get(`${this.semester}/active`, {
      params: { code: this.authService.account.code },
    });
  }

  getNonActiveSemester() {
    return this.http.get(`${this.semester}/non_active`, {
      params: { code: this.authService.account.code },
    });
  }

  paySemester(semester: any) {
    return this.http.get(`${this.semester}/pay`, {
      params: { id: semester.id },
    });
  }

  addAvailableCredits(semesterId: number, credits: number) {
    return this.http.get(`${this.semester}/add_available_credits`, {
      params: { id: semesterId, credits: credits },
    });
  }

  removeAvailableCredits(semesterId: number, credits: number) {
    return this.http.get(`${this.semester}/remove_available_credits`, {
      params: { id: semesterId, credits: credits },
    });
  }
}
