import { Component } from '@angular/core';
import { AccountTeacherService } from '../../core/services/account-teacher/account.teacher.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-teacher-groups',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './teacher-groups.component.html',
  styleUrl: './teacher-groups.component.css',
})
export class TeacherGroupsComponent {
  groups: any[] = [];
  groupSelected: any;
  studentsGroup: any[] = [];
  isSelectingGroups = true;

  constructor(private accountTeacherService: AccountTeacherService) {}

  ngOnInit() {
    this.accountTeacherService
      .getSubjectGroupsByTeacher()
      .subscribe((groups: any) => {
        this.groups = groups;
        console.log(this.groups);
      });
  }

  onBackButtonClicked() {
    this.isSelectingGroups = true;
    this.groupSelected = [];
    this.studentsGroup = [];
  }

  onGroupSelected(group: any) {
    this.groupSelected = group;
    this.accountTeacherService
      .getStudents(group.code)
      .subscribe((students: any) => {
        this.studentsGroup = students;
        this.isSelectingGroups = false;
        console.log(this.studentsGroup);
      });
  }

  saveRecord(item: any) {
    this.accountTeacherService
      .setStudentScore(item.id, item.p1, item.p2, item.p3)
      .subscribe();
  }
}
