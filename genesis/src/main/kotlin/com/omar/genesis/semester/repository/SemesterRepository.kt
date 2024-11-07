package com.omar.genesis.semester.repository

import com.omar.genesis.semester.model.Semester
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface SemesterRepository: JpaRepository<Semester, Long> {
    @Query("SELECT s FROM Semester s WHERE s.accountProgram.code = :code")
    fun getSemestersByCode(code: String): List<Semester>

    @Query("SELECT s FROM Semester s WHERE s.accountProgram.code = :code AND s.active = true")
    fun getActiveSemester(code: String): Semester

    @Query("SELECT s FROM Semester s WHERE s.accountProgram.code = :code AND s.active = false")
    fun getNonActiveSemester(code: String): List<Semester>

    @Modifying
    @Query("UPDATE Semester s SET s.paid = true WHERE s.id = :id")
    fun paySemester(id: Long)

    @Modifying
    @Query("UPDATE Semester s SET s.availableCredits = s.availableCredits + :credits, s.usedCredits = s.usedCredits - :credits WHERE s.id = :id")
    fun addAvailableCredits(id: Long, credits: Int)

    @Modifying
    @Query("UPDATE Semester s SET s.availableCredits = s.availableCredits - :credits, s.usedCredits = s.usedCredits + :credits WHERE s.id = :id")
    fun removeAvailableCredits(id: Long, credits: Int)
}