package com.omar.genesis.student.model

import com.omar.genesis.program.model.Program
import com.omar.genesis.user.model.User
import jakarta.persistence.*

@Entity(name = "Student")
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(nullable = false, unique = true)
    var code: String? = null,
    @Column(nullable = false)
    var password: String? = null,
    @ManyToOne
    var user: User? = null,
    @ManyToOne
    var program: Program? = null
)
