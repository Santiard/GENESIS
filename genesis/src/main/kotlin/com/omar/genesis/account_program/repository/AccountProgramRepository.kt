package com.omar.genesis.account_program.repository

import com.omar.genesis.account_program.model.AccountProgram
import com.omar.genesis.subject.model.Subject
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface AccountProgramRepository: JpaRepository<AccountProgram, Long> {
    @Query("SELECT a FROM AccountProgram a WHERE a.code = :code AND a.password = :password")
    fun login(code: String, password: String): AccountProgram?

    @Modifying
    @Query("UPDATE AccountProgram a SET a.icfes = :icfes WHERE a.code = :code")
    fun updateIcfes(code: String, icfes: ByteArray)

    @Modifying
    @Query("UPDATE AccountProgram a SET a.record = :record WHERE a.code = :code")
    fun updateRecord(code: String, record: ByteArray)

    @Modifying
    @Query("UPDATE AccountProgram a SET a.certificate = :certificate WHERE a.code = :code")
    fun updateCertificate(code: String, certificate: ByteArray)

    @Query("SELECT sj FROM AccountProgram a JOIN Pensum pe ON pe.academicProgram.id = a.program.id JOIN Subject sj ON sj.pensum.id = pe.id WHERE a.code = :code")
    fun getCurriculum(code: String): List<Subject>
}