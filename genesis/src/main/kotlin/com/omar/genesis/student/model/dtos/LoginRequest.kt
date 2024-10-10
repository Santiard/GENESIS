package com.omar.genesis.student.model.dtos

data class LoginRequest(
    val code: String,
    val password: String
)
