import { TestBed } from '@angular/core/testing';

import { GroupSemesterService } from './group.semester.service';

describe('GroupSemesterService', () => {
  let service: GroupSemesterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GroupSemesterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
