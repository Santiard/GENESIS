package com.omar.genesis.user.model

import jakarta.persistence.*

@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(unique = true, nullable = false)
    var document: String? = null,
    @Column(nullable = false)
    var firstName: String? = null,
    @Column(nullable = false)
    var lastName: String? = null,
    @Column(nullable = false, unique = true)
    var email: String? = null,
    @Column(nullable = false, unique = true)
    var phone: String? = null,
)
