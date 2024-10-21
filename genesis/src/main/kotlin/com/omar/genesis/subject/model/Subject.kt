package com.omar.genesis.subject.model

import com.omar.genesis.pensum.model.Pensum
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
data class Subject(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var name: String? = null,

    @Column(nullable = false)
    var semester: Int? = null,

    @Column(nullable = false)
    var credits: Int? = null,

    @ManyToOne
    @JoinColumn(nullable = false)
    var pensum: Pensum? = null
)
