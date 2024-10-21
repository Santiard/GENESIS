package com.omar.genesis.account_program.service

import com.omar.genesis.account_program.model.AccountProgram
import com.omar.genesis.account_program.repository.AccountProgramRepository
import com.omar.genesis.subject.model.Subject
import org.springframework.stereotype.Service

@Service
class AccountProgramService(private val repository: AccountProgramRepository) {
    fun login(code: String, password: String): AccountProgram?{
        return repository.login(code, password)
    }

    fun updateIcfes(code: String, icfes: ByteArray){
        repository.updateIcfes(code, icfes)
    }

    fun updateRecord(code: String, record: ByteArray){
        repository.updateRecord(code, record)
    }

    fun updateCertificate(code: String, certificate: ByteArray){
        repository.updateCertificate(code, certificate)
    }

    fun getCurriculum(code: String): List<Subject> {
        return repository.getCurriculum(code)
    }
}