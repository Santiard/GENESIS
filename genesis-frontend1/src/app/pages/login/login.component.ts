import { Component } from '@angular/core';
import { FooterComponent } from '../../layouts/footer/footer.component';
import { Router } from '@angular/router';
import { AuthService } from '../../core/services/auth/auth.service';
import { FormsModule } from '@angular/forms';
import { AccountTeacherService } from '../../core/services/account-teacher/account.teacher.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FooterComponent, FormsModule],
  templateUrl: './login.component.html',
  styles: ``,
})
export class LoginComponent {
  code = '03210131021';
  password = '123';

  constructor(
    private router: Router,
    private authService: AuthService,
    private accountTeacherService: AccountTeacherService,
  ) {}

  ngAfterViewInit() {
    if (this.authService.account != null) {
      this.router.navigate(['dashboard']);
    }
    this.login();
  }

  login() {
    this.authService
      .login(this.code, this.password)
      .subscribe((response: any) => {
        if (response != null) {
          this.authService.account = response;
          this.router.navigate(['dashboard']);
        } else {
          this.accountTeacherService
            .login(this.code, this.password)
            .subscribe((response: any) => {
              if (response != null) {
                this.authService.account = response;
                this.authService.isTeacher = true;
                this.router.navigate(['dashboard']);
              } else alert('Invalid login');
            });
        }
      });
  }
}
