package com.omar.genesis.group_semester.repository

import com.omar.genesis.group_semester.model.GroupSemester
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.time.Year

@Repository
interface GroupSemesterRepository: JpaRepository<GroupSemester, Long> {
    @Query("SELECT gs FROM GroupSemester gs WHERE gs.semester.accountProgram.code = :code AND gs.semester.active = true")
    fun getByUserCode(code: String): List<GroupSemester>

    @Query("SELECT gs FROM GroupSemester gs WHERE gs.semester.accountProgram.code = :code AND gs.semester.year = :year AND gs.semester.period = :period")
    fun getByUserCodeYearPeriod(code: String, year: Year, period: Char): List<GroupSemester>
}