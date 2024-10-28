import { Component } from '@angular/core';
import { AuthService } from '../../core/services/auth/auth.service';
import { GroupSemesterService } from '../../core/services/group-semester/group.semester.service';

@Component({
  selector: 'app-stdscores',
  standalone: true,
  imports: [],
  templateUrl: './stdscores.component.html',
  styles: ``,
})
export class StdscoresComponent {
  stdScores: any[] = [];

  constructor(
    public authService: AuthService,
    public groupSemesterService: GroupSemesterService,
  ) {}

  ngOnInit() {
    this.authService.isLogged();
    this.groupSemesterService.getStdScores().subscribe((res: any) => {
      this.stdScores = res;
    });
  }
}
