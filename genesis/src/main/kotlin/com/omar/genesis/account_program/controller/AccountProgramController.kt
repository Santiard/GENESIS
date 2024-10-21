package com.omar.genesis.account_program.controller

import com.omar.genesis.account_program.dto.DocumentRequest
import com.omar.genesis.account_program.dto.LoginRequest
import com.omar.genesis.account_program.model.AccountProgram
import com.omar.genesis.account_program.service.AccountProgramService
import com.omar.genesis.subject.model.Subject
import jakarta.transaction.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@Transactional
@RequestMapping("/account_program")
class AccountProgramController(private val service: AccountProgramService) {

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): AccountProgram? {
        return service.login(request.code, request.password)
    }

    @PostMapping("/update_icfes")
    fun updateIcfes(@RequestBody request: DocumentRequest){
        service.updateIcfes(request.code, request.document)
    }

    @PostMapping("/update_record")
    fun updateRecord(@RequestBody request: DocumentRequest){
        service.updateRecord(request.code, request.document)
    }

    @PostMapping("/update_certificate")
    fun updateCertificate(@RequestBody request: DocumentRequest){
        service.updateCertificate(request.code, request.document)
    }

    @GetMapping("/curriculum")
    fun getCurriculum(@RequestParam code: String): List<Subject> {
        return service.getCurriculum(code)
    }
}