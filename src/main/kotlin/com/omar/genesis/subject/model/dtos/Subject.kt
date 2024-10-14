package com.omar.genesis.subject.model

import com.omar.genesis.program.model.Program
import jakarta.persistence.*

@Entity(name = "Subject")
data class Subject(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false, unique = true)
    var name : String? = null,

    @Column(nullable = false)
    var credits : Int? = null,

    @ManyToMany
    @JoinTable(
        name = "subject_prerequisites",
        joinColumns = [JoinColumn(name = "subject_id")],
        inverseJoinColumns = [JoinColumn(name = "prerequisite_id")]
    )
    val prerequisites: List<Subject> = listOf(),// Relación con otras materias

    @Column(nullable = false)
    var hours : Int? = null,

    @Column(nullable = false)
    var hours : Int? = null,

    @JoinTable(
        name = "subject_program",
        joinColumns = [JoinColumn(name = "subject_id")],
        inverseJoinColumns = [JoinColumn(name = "program_id")]
    )
    val prerequisites: List<Program> = listOf(),// Relación con otras materias


)
