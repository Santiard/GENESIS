import { Component } from '@angular/core';
import { AuthService } from '../../core/services/auth/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [],
  templateUrl: './header.component.html',
  styles: ``,
})
export class HeaderComponent {
  constructor(
    public authService: AuthService,
    private router: Router,
  ) {}

  ngOnInit() {
    this.authService.isLogged();
  }

  dashboard() {
    this.router.navigate(['dashboard']);
  }

  logout() {
    this.authService.account = null;
    this.router.navigate(['']);
  }
}
