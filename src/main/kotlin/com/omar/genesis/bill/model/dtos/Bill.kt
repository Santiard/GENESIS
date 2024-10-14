package com.omar.genesis.bill.model.dtos

import com.omar.genesis.student.model.Student
import com.omar.genesis.classroom.model.dto.ClassroomDetails
import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalTime

@Entity(name = "Bill")
data class Bill(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    // Fecha de emisión de la factura
    @Column(nullable = false)
    var issueDate: LocalDate? = null,

    // Estudiante al que se le emite la factura (relación muchos a uno)
    @JoinColumn(nullable = false)
    @ManyToOne
    var student: Student? = null,

    // Monto total a pagar
    @Column(nullable = false)
    var value: BigDecimal? = null,

    // Detalle de los conceptos facturados
    @Column(nullable = false)
    var detail: String? = null,

)