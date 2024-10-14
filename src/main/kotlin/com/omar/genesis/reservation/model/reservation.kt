package com.omar.genesis.reservation.model

import com.omar.genesis.user.model.User
import com.omar.genesis.classroom.model.dto.ClassroomDetails
import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalTime


@Entity(name = "Reservation")
data class reservation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    @ManyToOne
    val Classroom: Classroom? = null,

    @Colum (nullable = false)
    val reservationDate : LocalDate? = null,

    @Colum (nullable = false)
    val startDateTime : LocalTime? = null,

    @Colum (nullable = false)
    val endDateTime : LocalTime? = null,

    @JoinColumn(nullable = false)
    @ManyToOne
    var user: User? = null


)
