package com.omar.genesis.group_semester.service

import com.omar.genesis.group_semester.model.GroupSemester
import com.omar.genesis.group_semester.repository.GroupSemesterRepository
import org.springframework.stereotype.Service
import java.time.Year

@Service
class GroupSemesterService(private val repository: GroupSemesterRepository) {
    fun getByUserCode(code: String): List<GroupSemester> {
        return repository.getByUserCode(code)
    }

    fun getByUserCodeYearPeriod(code: String, year: Int, period: Char): List<GroupSemester> {
        val year = Year.of(year)
        return repository.getByUserCodeYearPeriod(code, year, period)
    }
}