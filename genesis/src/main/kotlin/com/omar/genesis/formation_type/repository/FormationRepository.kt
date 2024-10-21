package com.omar.genesis.modality.repository

import com.omar.genesis.modality.model.FormationType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FormationRepository: JpaRepository<FormationType, Long> {}