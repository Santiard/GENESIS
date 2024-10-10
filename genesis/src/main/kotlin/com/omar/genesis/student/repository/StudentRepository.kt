package com.omar.genesis.student.repository

import com.omar.genesis.student.model.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : JpaRepository<Student, Long> {
    @Query("select st from Student st where st.code = :code and st.password = :password")
    fun login(code: String, password: String): Student?

    fun getByCode(code: String): Student?

    @Query("select st from Student st where st.user.document = :document")
    fun getByDocument(document: String): Student?
}