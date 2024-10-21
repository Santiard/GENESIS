package com.omar.genesis.semester.model

import com.omar.genesis.account_program.model.AccountProgram
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.time.LocalDate
import java.time.Year

@Entity
data class Semester(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(nullable = false)
    var accountProgram: AccountProgram? = null,

    @Column(nullable = false)
    var year: Year? = null,

    @Column(nullable = false)
    var semester: Int? = null,

    @Column(nullable = false)
    var paid: Boolean? = null,

    @Column(nullable = false)
    var startDate: LocalDate? = null,

    @Column(nullable = false)
    var endDate: LocalDate? = null,

    @Column(nullable = false)
    var semesterValue: Double? = null,

    @Column(nullable = false)
    var active: Boolean? = null,

    @Column(nullable = false)
    var period: Char? = null,

    @Column(nullable = false)
    var average: Double? = null,

    @Column(nullable = false)
    var availableCredits: Int? = null,

    @Column(nullable = false)
    var usedCredits: Int? = null
)
