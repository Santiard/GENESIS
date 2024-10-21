package com.omar.genesis.pensum.repository

import com.omar.genesis.pensum.model.Pensum
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PensumRepository: JpaRepository<Pensum, Long> {
}