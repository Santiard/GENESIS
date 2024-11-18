package com.omar.genesis.account_teacher.model

import com.omar.genesis.academic_program.model.AcademicProgram
import com.omar.genesis.user.model.User
import jakarta.persistence.*

@Entity
data class AccountTeacher(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(nullable = false)
    var user: User? = null,

    @ManyToOne
    @JoinColumn(nullable = false)
    var program: AcademicProgram? = null,

    @Column(nullable = false, unique = true)
    var code: String? = null,

    @Column(nullable = false)
    var password: String? = null
)
