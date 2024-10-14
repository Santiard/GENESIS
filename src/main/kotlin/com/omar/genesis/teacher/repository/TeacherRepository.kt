package com.omar.genesis.teacher.repository

import com.omar.genesis.teacher.model.Teacher
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface TeacherRepository : JpaRepository<Teacher, Long> {
    @Query("select te from Student te where te.code = :code and te.password = :password")
    fun login(code: String, password: String): Teacher?

    fun getByCode(code: String): Student?

    @Query("select te from Student te where te.user.document = :document")
    fun getByDocument(document: String): Teacher?
}