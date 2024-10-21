import { Component } from '@angular/core';
import { FooterComponent } from '../../layouts/footer/footer.component';
import { Router } from '@angular/router';
import { AuthService } from '../../core/services/auth/auth.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FooterComponent, FormsModule],
  templateUrl: './login.component.html',
  styles: ``,
})
export class LoginComponent {
  code = '';
  password = '';

  constructor(
    private router: Router,
    private authService: AuthService,
  ) {}

  ngAfterViewInit() {
    if (this.authService.account != null) {
      this.router.navigate(['dashboard']);
    }
  }

  login() {
    this.authService
      .login(this.code, this.password)
      .subscribe((response: any) => {
        if (response != null) {
          this.authService.account = response;
          this.router.navigate(['dashboard']);
        } else {
          alert('Invalid login');
        }
      });
  }
}
