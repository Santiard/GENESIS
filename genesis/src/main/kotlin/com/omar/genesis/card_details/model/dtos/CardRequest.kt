package com.omar.genesis.card_details.model.dtos

import com.omar.genesis.card_details.model.CardDetails

data class CardRequest(
    val cardOwnerName: String,
    val cardNumber: String,
    val expirationMonth: Byte,
    val expirationYear: Short,
    val cvv: String
)

fun CardRequest.toCardDetails() = CardDetails(
    cardOwnerName = cardOwnerName,
    cvv = cvv,
    cardNumber = cardNumber,
    expirationYear = expirationYear,
    expirationMonth = expirationMonth
)