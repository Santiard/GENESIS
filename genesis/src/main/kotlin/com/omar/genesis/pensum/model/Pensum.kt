package com.omar.genesis.pensum.model

import com.omar.genesis.academic_program.model.AcademicProgram
import jakarta.persistence.*

@Entity
data class Pensum(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(nullable = false)
    var academicProgram: AcademicProgram? = null,

    @Column(nullable = false)
    var semesterNumber: Int?  = null,

    @Column(nullable = false)
    var active: Boolean? = null
)
