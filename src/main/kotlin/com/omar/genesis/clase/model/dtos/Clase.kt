package com.omar.genesis.clase.model

import com.omar.genesis.program.model.Program
import com.omar.genesis.teacher.model.Teacher
import com.omar.genesis.classroom.model.ClasssroomDetails
import jakarta.persistence.*
import java.time.LocalTime

@Entity(name = "Clase")
data class Clase(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false, unique = true)
    var name : String? = null,


    @JoinColumn(nullable = false)
    @ManyToOne
    var teacher: Teacher? = null

    @JoinColumn(nullable = false)
    @ManyToOne
    var classroom: Classroom? = null

    @Column(nullable = false, unique = true)
    var starclass : LocalTime = null,

    @Column(nullable = false, unique = true)
    var endclass : LocalTime = null,

    @ManyToMany
    @JoinTable(
        name = "subject_prerequisites",
        joinColumns = [JoinColumn(name = "subject_id")],
        inverseJoinColumns = [JoinColumn(name = "prerequisite_id")]
    )
    val prerequisites: List<Subject> = listOf(),// Relación con otras materias

    @Column(nullable = false)
    var hours : Int? = null,



    @JoinTable(
        name = "subject_program",
        joinColumns = [JoinColumn(name = "subject_id")],
        inverseJoinColumns = [JoinColumn(name = "program_id")]
    )
    val prerequisites: List<Program> = listOf(),// Relación con otras materias


    @ManyToMany
    @JoinTable(
        name = "subject_student",
        joinColumns = [JoinColumn(name = "subject_id")],
        inverseJoinColumns = [JoinColumn(name = "student_id")]
    )
    val prerequisites: List<Student> = listOf(),// Relación con otras materias
    )
