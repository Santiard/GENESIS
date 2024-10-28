import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private accountProgram = 'http://localhost:8080/account_program';
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
}
