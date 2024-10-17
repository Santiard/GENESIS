package com.omar.genesis.user.repository

import com.omar.genesis.user.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findByDocument(document: String): User?
    fun findByEmail(email: String): User?
}