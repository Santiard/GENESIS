package com.omar.genesis.card_details.repository

import com.omar.genesis.card_details.model.CardDetails
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CardDetailsRepository : JpaRepository<CardDetails, Long> {
    @Query("SELECT cd FROM CardDetails cd WHERE cd.user.document = :document")
    fun getByUserDocument(document: String): List<CardDetails>
}