package com.omar.genesis.subject_group.repository

import com.omar.genesis.subject.model.Subject
import com.omar.genesis.subject_group.model.SubjectGroup
import com.omar.genesis.subject_group.model.SubjectGroupSchedule
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface SubjectGroupScheduleRepository: JpaRepository<SubjectGroupSchedule, Long> {
    @Query("SELECT s FROM SubjectGroupSchedule s WHERE s.group.code = :subjectGroupCode")
    fun findBySubjectGroupCode(subjectGroupCode: String): List<SubjectGroupSchedule>
}