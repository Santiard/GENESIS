package com.omar.genesis.account_program.dto

data class LoginRequest(
    val code: String,
    val password: String
)