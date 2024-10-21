package com.omar.genesis.subject_group.model

import com.omar.genesis.subject.model.Subject
import jakarta.persistence.*
import java.time.LocalDate

@Entity
data class SubjectGroup(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(nullable = false)
    var subject: Subject? = null,

    @Column(nullable = false)
    var code: String? = null,

    @Column(nullable = false)
    var startDate: LocalDate? = null,

    @Column(nullable = false)
    var endDate: LocalDate? = null,

    @Column(nullable = false)
    var creationDate: LocalDate? = null,
)
