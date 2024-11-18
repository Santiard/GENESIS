package com.omar.genesis.account_teacher.repository

import com.omar.genesis.account_teacher.model.AccountTeacher
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface AccountTeacherRepository: JpaRepository<AccountTeacher, Long> {
    @Query("SELECT a FROM AccountTeacher a WHERE a.code = :code AND a.password = :password")
    fun login(code: String, password: String): AccountTeacher?
}