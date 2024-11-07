package com.omar.genesis.group_semester.controller

import com.omar.genesis.group_semester.model.GroupSemester
import com.omar.genesis.group_semester.model.GroupSemesterDto
import com.omar.genesis.group_semester.service.GroupSemesterService
import com.omar.genesis.subject_group.model.SubjectGroupSchedule
import jakarta.transaction.Transactional
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@Transactional
@RequestMapping("/group-semester")
class GroupSemesterController(private val service: GroupSemesterService) {
    @GetMapping("/get_all_schedules")
    fun getAll(): List<SubjectGroupSchedule> {
        return service.getAll()
    }

    @GetMapping("/get_by_user_code")
    fun getByUserCode(@RequestParam  code: String): List<GroupSemester> {
        return service.getByUserCode(code)
    }

    @GetMapping("/get_by_user_code_year_period")
    fun getByUserCodeYearPeriod(@RequestParam code: String, @RequestParam year: Int, @RequestParam period: Char): List<GroupSemester> {
        return service.getByUserCodeYearPeriod(code, year, period)
    }

    @GetMapping("/get_schedule_by_group_semester_code")
    fun getScheduleByGroupSemesterCode(@RequestParam code: String): List<SubjectGroupSchedule> {
        return service.getScheduleByGroupSemesterCode(code)
    }

    @PostMapping("/enroll")
    fun enroll(@RequestBody request: GroupSemesterDto){
        service.enroll(request)
    }

    @PostMapping("/unenroll")
    fun unenroll(@RequestBody request: GroupSemesterDto){
        service.unenroll(request)
    }
}