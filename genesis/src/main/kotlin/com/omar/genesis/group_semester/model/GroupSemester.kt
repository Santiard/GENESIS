package com.omar.genesis.group_semester.model

import com.omar.genesis.subject_group.model.SubjectGroup
import com.omar.genesis.semester.model.Semester
import jakarta.persistence.*
import java.time.LocalDate

@Entity
data class GroupSemester(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(nullable = false)
    var subjectGroup: SubjectGroup? = null,

    @ManyToOne
    @JoinColumn(nullable = false)
    var semester: Semester? = null,

    @Column(nullable = false)
    var registerDate : LocalDate? = null,

    @Column(nullable = false)
    var p1: Float? = null,

    @Column(nullable = false)
    var p2: Float? = null,

    @Column(nullable = false)
    var p3: Float? = null,
)
