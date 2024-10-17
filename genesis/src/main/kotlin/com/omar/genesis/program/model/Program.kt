package com.omar.genesis.program.model

import jakarta.persistence.*

@Entity(name = "Program")
data class Program(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(nullable = false, unique = true)
    var name : String? = null,
    @Column(nullable = false)
    var credits : Int? = null,
)
