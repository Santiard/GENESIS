import { Injectable } from '@angular/core';
import { AuthService } from '../auth/auth.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class GroupSemesterService {
  private groupSemester = 'http://localhost:8080/group-semester';
  constructor(
    private authService: AuthService,
    private http: HttpClient,
    private router: Router,
  ) {}

  getStdScores() {
    return this.http.get(`${this.groupSemester}/get_by_user_code`, {
      params: { code: this.authService.account.code },
    });
  }

  getStdScoresBySemesterNonActive(semester: any) {
    return this.http.get(`${this.groupSemester}/get_by_user_code_year_period`, {
      params: {
        code: this.authService.account.code,
        year: semester.year,
        period: semester.period,
      },
    });
  }

  getGroupSchedule(groupCode: string) {
    return this.http.get(
      `${this.groupSemester}/get_schedule_by_group_semester_code`,
      {
        params: { code: groupCode },
      },
    );
  }
}
