package com.omar.genesis.student.controller

import com.omar.genesis.card_details.model.CardDetails
import com.omar.genesis.student.model.dtos.LoginRequest
import com.omar.genesis.student.model.dtos.UserCardRequest
import com.omar.genesis.student.service.StudentService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/student")
class StudentController(private val studentService: StudentService) {
    @PostMapping("")
    fun login(@RequestBody request: LoginRequest): Boolean {
        return studentService.login(request)
    }

    @PostMapping("/card-details")
    fun saveCardDetails(@RequestBody request: UserCardRequest): Boolean {
        return studentService.saveCardDetails(request)
    }

    @GetMapping("/card-details")
    fun getCardDetails(@RequestParam document: String): List<CardDetails> {
        return studentService.getCardDetails(document)
    }
}