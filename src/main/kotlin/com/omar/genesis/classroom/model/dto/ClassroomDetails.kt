package com.omar.genesis.classroom.model

import jakarta.persistence.*

@Entity(name = "Classroom")
data class ClassroomDetails(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(unique = true, nullable = false)
    var name: String? = null,

    @Column(nullable = false)
    val building: String? = null,

    @Column(nullable = false)
    val availability: Boolean,

    @Colum(nullable = false)
    val equipment: List<String>,

    @Colum(nullable = false)
    val capacity: Int

)