import { Component } from '@angular/core';
import { AuthService } from '../../core/services/auth/auth.service';

@Component({
  selector: 'app-stdscores',
  standalone: true,
  imports: [],
  templateUrl: './stdscores.component.html',
  styles: ``,
})
export class StdscoresComponent {
  stdScores: any[] = [];

  constructor(public authService: AuthService) {}

  ngOnInit() {
    this.authService.isLogged();
    this.authService.getStdScores().subscribe((res: any) => {
      this.stdScores = res;
    });
  }
}
