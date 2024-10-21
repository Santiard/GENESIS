package com.omar.genesis.semester.controller

import com.omar.genesis.semester.model.Semester
import com.omar.genesis.semester.service.SemesterService
import jakarta.transaction.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@Transactional
@RequestMapping("/semester")
class SemesterController(private val service: SemesterService) {
    @GetMapping("/code")
    fun getSemesterCode(@RequestParam code: String): List<Semester> {
        return service.getSemestersByCode(code)
    }

    @GetMapping("/active")
    fun getActiveSemester(@RequestParam code: String): Semester {
        return service.getActiveSemesterByCode(code)
    }

    @GetMapping("/non_active")
    fun getNonActiveSemester(@RequestParam code: String): List<Semester> {
        return service.getNonActiveSemesterByCode(code)
    }

    @GetMapping("/pay")
    fun paySemester(@RequestParam id: Long) {
        return service.paySemester(id)
    }
}