package com.omar.genesis.student.model.dtos

import com.omar.genesis.card_details.model.dtos.CardRequest

data class UserCardRequest(
    val document: String,
    val card: CardRequest
)
