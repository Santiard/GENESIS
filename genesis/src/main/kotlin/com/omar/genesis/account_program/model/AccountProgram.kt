package com.omar.genesis.account_program.model

import com.omar.genesis.academic_program.model.AcademicProgram
import com.omar.genesis.user.model.User
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.Lob
import jakarta.persistence.ManyToOne

@Entity
data class AccountProgram(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(nullable = false)
    var user: User? = null,

    @ManyToOne
    @JoinColumn(nullable = false)
    var program: AcademicProgram? = null,

    @Lob
    @Column(columnDefinition = "BLOB")
    var certificate: ByteArray? = null,

    @Lob
    @Column(columnDefinition = "BLOB")
    var record: ByteArray? = null,

    @Lob
    @Column(columnDefinition = "BLOB")
    var icfes: ByteArray? = null,

    @Column(nullable = false, unique = true)
    var code: String? = null,

    @Column(nullable = false)
    var password: String? = null
)
