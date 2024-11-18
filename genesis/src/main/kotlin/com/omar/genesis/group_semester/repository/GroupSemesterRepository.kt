package com.omar.genesis.group_semester.repository

import com.omar.genesis.group_semester.model.GroupSemester
import org.hibernate.sql.Update
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.time.Year

@Repository
interface GroupSemesterRepository: JpaRepository<GroupSemester, Long> {
    @Query("SELECT gs FROM GroupSemester gs WHERE gs.semester.accountProgram.code = :code AND gs.semester.active = true")
    fun getByUserCode(code: String): List<GroupSemester>

    @Query("SELECT gs FROM GroupSemester gs WHERE gs.semester.accountProgram.code = :code AND gs.semester.year = :year AND gs.semester.period = :period")
    fun getByUserCodeYearPeriod(code: String, year: Year, period: Char): List<GroupSemester>

    @Modifying
    @Query("DELETE FROM GroupSemester gs WHERE gs.subjectGroup.id = :subjectGroupId AND gs.semester.id = :semesterId")
    fun deleteByGroupIdAndSemesterId(subjectGroupId: Long, semesterId: Long)

    @Query("SELECT gs FROM GroupSemester gs WHERE gs.subjectGroup.code = :code")
    fun getStudentsBySubjectGroup(code: String): List<GroupSemester>

    @Modifying
    @Query("UPDATE GroupSemester gs SET gs.p1 = :p1, gs.p2 = :p2, gs.p3 = :p3 WHERE gs.id = :id")
    fun setRecords(id: Long, p1: Float, p2: Float, p3: Float)
}