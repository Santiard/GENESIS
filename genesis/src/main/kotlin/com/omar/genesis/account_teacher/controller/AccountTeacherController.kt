package com.omar.genesis.account_teacher.controller

import com.omar.genesis.account_program.dto.LoginRequest
import com.omar.genesis.account_teacher.dto.StudentRecordsRequest
import com.omar.genesis.account_teacher.model.AccountTeacher
import com.omar.genesis.account_teacher.service.AccountTeacherService
import com.omar.genesis.group_semester.model.GroupSemester
import com.omar.genesis.subject_group.model.SubjectGroup
import jakarta.transaction.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@Transactional
@RequestMapping("/account_teacher")
class AccountTeacherController(
    private val service: AccountTeacherService
) {
    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): AccountTeacher? {
        return service.login(request.code, request.password)
    }

    @GetMapping("/subject_groups")
    fun getSubjectGroups(@RequestParam code: String): List<SubjectGroup> {
        return service.getSubjectGroupsByTeacher(code)
    }

    @GetMapping("/students")
    fun getStudents(@RequestParam code: String): List<GroupSemester> {
        return service.getStudentsBySubjectGroup(code)
    }

    @PostMapping("/set_records")
    fun setRecords(@RequestBody request: StudentRecordsRequest){
        service.setStudentRecords(request)
    }
}