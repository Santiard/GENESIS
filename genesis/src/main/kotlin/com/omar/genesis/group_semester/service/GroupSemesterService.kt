package com.omar.genesis.group_semester.service

import com.omar.genesis.group_semester.model.GroupSemester
import com.omar.genesis.group_semester.model.GroupSemesterDto
import com.omar.genesis.group_semester.repository.GroupSemesterRepository
import com.omar.genesis.semester.repository.SemesterRepository
import com.omar.genesis.subject_group.model.SubjectGroupSchedule
import com.omar.genesis.subject_group.repository.SubjectGroupScheduleRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.Year

@Service
class GroupSemesterService(
    private val repository: GroupSemesterRepository,
    private val schedule: SubjectGroupScheduleRepository,
    private val semester: SemesterRepository
) {
    fun getByUserCode(code: String): List<GroupSemester> {
        return repository.getByUserCode(code)
    }

    fun getByUserCodeYearPeriod(code: String, year: Int, period: Char): List<GroupSemester> {
        val year = Year.of(year)
        return repository.getByUserCodeYearPeriod(code, year, period)
    }

    fun getScheduleByGroupSemesterCode(code: String): List<SubjectGroupSchedule> {
        return schedule.findBySubjectGroupCode(code)
    }

    fun getAll(): List<SubjectGroupSchedule> {
        return schedule.findAll()
    }

    fun enroll(request: GroupSemesterDto) {
        val groupSemester = GroupSemester(
            semester = request.semester,
            subjectGroup = request.subjectGroup,
            p1 = 0F,
            p2 = 0F,
            p3 = 0F,
            registerDate = LocalDate.now()
        )
        semester.removeAvailableCredits(request.semester.id!!, request.subjectGroup.subject!!.credits!!)
        repository.save(groupSemester)
    }

    fun unenroll(request: GroupSemesterDto){
        semester.addAvailableCredits(request.semester.id!!, request.subjectGroup.subject!!.credits!!)
        repository.deleteByGroupIdAndSemesterId(request.subjectGroup.id!!, request.semester.id!!)
    }
}