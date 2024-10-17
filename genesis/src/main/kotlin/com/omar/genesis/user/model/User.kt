package com.omar.genesis.user.model

import jakarta.persistence.*

@Entity(name = "User")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(unique = true, nullable = false)
    var document: String? = null,
    @Column(nullable = false)
    val firstName: String? = null,
    @Column(nullable = false)
    val lastName: String? = null,
    @Column(nullable = false)
    val email: String? = null,
)
