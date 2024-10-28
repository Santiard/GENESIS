package com.omar.genesis.subject_group.model

import com.omar.genesis.subject.model.Subject
import jakarta.persistence.*
import java.time.LocalDate

@Entity
data class SubjectGroupSchedule(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(nullable = false)
    var group: SubjectGroup? = null,

    @Column(nullable = false)
    var startTime: Byte? = null,

    @Column(nullable = false)
    var numberHours: Byte? = null,

    @Column(nullable = false)
    var dayOfWeek: Byte? = null,

    @Column(nullable = false)
    var creationDate: LocalDate? = null,
)
