import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { AuthService } from '../auth/auth.service';

@Injectable({
  providedIn: 'root',
})
export class AccountTeacherService {
  private accountTeacher = 'http://localhost:8080/account_teacher';

  constructor(
    private http: HttpClient,
    private authService: AuthService,
  ) {}

  login(code: string, password: string) {
    return this.http.post(`${this.accountTeacher}/login`, {
      code: code,
      password: password,
    });
  }

  getSubjectGroupsByTeacher() {
    return this.http.get(`${this.accountTeacher}/subject_groups`, {
      params: { code: this.authService.account.code },
    });
  }

  getStudents(code: string) {
    return this.http.get(`${this.accountTeacher}/students`, {
      params: { code: code },
    });
  }

  setStudentScore(groupSemesterId: string, p1: number, p2: number, p3: number) {
    return this.http.post(`${this.accountTeacher}/set_records`, {
      groupSemesterId: groupSemesterId,
      p1: p1,
      p2: p2,
      p3: p3,
    });
  }
}
