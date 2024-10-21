package com.omar.genesis.semester.service

import com.omar.genesis.semester.repository.SemesterRepository
import org.springframework.stereotype.Service

@Service
class SemesterService(private val repository: SemesterRepository) {
    fun getSemestersByCode(code: String) = repository.getSemestersByCode(code)
    fun getActiveSemesterByCode(code: String) = repository.getActiveSemester(code)
    fun getNonActiveSemesterByCode(code: String) = repository.getNonActiveSemester(code)
    fun paySemester(id: Long) = repository.paySemester(id)
}