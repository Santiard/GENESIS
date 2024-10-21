package com.omar.genesis.academic_program.model

import com.omar.genesis.modality.model.FormationType
import com.omar.genesis.modality.model.Modality
import jakarta.persistence.*

@Entity
data class AcademicProgram(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(nullable = false)
    var modality: Modality? = null,

    @ManyToOne
    @JoinColumn(nullable = false)
    var formationType: FormationType? = null,

    @Column(nullable = false, unique = true)
    var name: String? = null,

    @Column(nullable = false)
    var description: String? = null,

    @Column(nullable = false)
    var semesterValue: Double? = null
)