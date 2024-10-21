package com.omar.genesis.card_details.model

import com.omar.genesis.user.model.User
import jakarta.persistence.*
import java.time.LocalDate

@Entity
data class CardDetails(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val cardOwnerName: String? = null,

    @Column(nullable = false)
    val cardNumber: String? = null,

    @Column(nullable = false)
    val expirationMonth: Byte? = null,

    @Column(nullable = false)
    val expirationYear: Short? = null,

    @Column(nullable = false)
    val cvv: String? = null,

    @JoinColumn(nullable = false)
    @ManyToOne
    var user: User? = null
)
