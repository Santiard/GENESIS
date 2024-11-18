package com.omar.genesis.account_teacher.service

import com.omar.genesis.account_teacher.dto.StudentRecordsRequest
import com.omar.genesis.account_teacher.model.AccountTeacher
import com.omar.genesis.account_teacher.repository.AccountTeacherRepository
import com.omar.genesis.group_semester.model.GroupSemester
import com.omar.genesis.group_semester.repository.GroupSemesterRepository
import com.omar.genesis.subject_group.model.SubjectGroup
import com.omar.genesis.subject_group.repository.SubjectGroupRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
@Transactional
class AccountTeacherService(
    private val accountTeacherRepository: AccountTeacherRepository,
    private val subjectGroupRepository: SubjectGroupRepository,
    private val groupSemesterRepository: GroupSemesterRepository
) {
    fun login(code: String, password: String): AccountTeacher?{
        return accountTeacherRepository.login(code, password)
    }

    fun getSubjectGroupsByTeacher(code: String): List<SubjectGroup> {
        return subjectGroupRepository.getSubjectGroupsByTeacher(code)
    }

    fun getStudentsBySubjectGroup(code: String): List<GroupSemester> {
        return groupSemesterRepository.getStudentsBySubjectGroup(code)
    }

    fun setStudentRecords(request: StudentRecordsRequest){
        request.p1 = request.p1 ?: 0.0f
        request.p2 = request.p2 ?: 0.0f
        request.p3 = request.p3 ?: 0.0f

        groupSemesterRepository.setRecords(request.groupSemesterId, request.p1!!, request.p2!!, request.p3!!)
    }

}