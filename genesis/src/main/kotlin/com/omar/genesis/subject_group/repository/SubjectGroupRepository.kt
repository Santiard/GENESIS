package com.omar.genesis.subject_group.repository

import com.omar.genesis.subject.model.Subject
import com.omar.genesis.subject_group.model.SubjectGroup
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface SubjectGroupRepository: JpaRepository<SubjectGroup, Long> {
    @Query("SELECT sg FROM SubjectGroup sg WHERE sg.teacher.code = :code")
    fun getSubjectGroupsByTeacher(code: String): List<SubjectGroup>
}