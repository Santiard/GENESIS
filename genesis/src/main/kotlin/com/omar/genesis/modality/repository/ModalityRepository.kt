package com.omar.genesis.modality.repository

import com.omar.genesis.modality.model.Modality
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ModalityRepository: JpaRepository<Modality, Long> {}