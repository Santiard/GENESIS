package com.omar.genesis.student.service

import com.omar.genesis.card_details.model.CardDetails
import com.omar.genesis.card_details.model.dtos.toCardDetails
import com.omar.genesis.card_details.repository.CardDetailsRepository
import com.omar.genesis.student.model.dtos.LoginRequest
import com.omar.genesis.student.model.dtos.UserCardRequest
import com.omar.genesis.student.repository.StudentRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class StudentService(
    private val repository: StudentRepository,
    private val cardDetailsRepository: CardDetailsRepository
) {
    fun login(request: LoginRequest): Boolean {
        val user = repository.login(request.code, request.password)
        return user != null
    }

    fun saveCardDetails(request: UserCardRequest): Boolean {
        val user = repository.getByDocument(request.document) ?: return false
        val cardDetails = request.card.toCardDetails()
        cardDetails.user = user.user

        cardDetailsRepository.save(cardDetails)
        return true
    }

    fun getCardDetails(code: String): List<CardDetails> {
        return cardDetailsRepository.getByUserDocument(code)
    }
}