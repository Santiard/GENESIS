import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private accountProgram = 'http://localhost:8080/account_program';
  private groupSemester = 'http://localhost:8080/group-semester';
  private semester = 'http://localhost:8080/semester';
  account: any;

  constructor(
    private http: HttpClient,
    private router: Router,
  ) {}

  isLogged() {
    if (this.account == null) this.router.navigate(['']);
  }

  login(code: string, password: string) {
    return this.http.post(`${this.accountProgram}/login`, {
      code: code,
      password: password,
    });
  }

  curriculum() {
    return this.http.get(`${this.accountProgram}/curriculum`, {
      params: { code: this.account.code },
    });
  }

  updateIcfes(document: any) {
    return this.http.post(`${this.accountProgram}/update_icfes`, {
      code: this.account.code,
      document: document,
    });
  }

  updateRecord(document: any) {
    return this.http.post(`${this.accountProgram}/update_record`, {
      code: this.account.code,
      document: document,
    });
  }

  updateCertificate(document: any) {
    return this.http.post(`${this.accountProgram}/update_certificate`, {
      code: this.account.code,
      document: document,
    });
  }

  getStdScores() {
    return this.http.get(`${this.groupSemester}/get_by_user_code`, {
      params: { code: this.account.code },
    });
  }

  getStdScoresBySemesterNonActive(semester: any) {
    return this.http.get(`${this.groupSemester}/get_by_user_code_year_period`, {
      params: {
        code: this.account.code,
        year: semester.year,
        period: semester.period,
      },
    });
  }

  getSemesters() {
    return this.http.get(`${this.semester}/code`, {
      params: { code: this.account.code },
    });
  }

  getActiveSemester() {
    return this.http.get(`${this.semester}/active`, {
      params: { code: this.account.code },
    });
  }

  getNonActiveSemester() {
    return this.http.get(`${this.semester}/non_active`, {
      params: { code: this.account.code },
    });
  }

  paySemester(semester: any) {
    return this.http.get(`${this.semester}/pay`, {
      params: { id: semester.id },
    });
  }
}
