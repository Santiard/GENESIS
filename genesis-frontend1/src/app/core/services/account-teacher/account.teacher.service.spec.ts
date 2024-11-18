import { TestBed } from '@angular/core/testing';

import { AccountTeacherService } from './account.teacher.service';

describe('AccountTeacherService', () => {
  let service: AccountTeacherService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AccountTeacherService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
