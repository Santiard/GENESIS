package com.omar.genesis.academic_program.repository

import com.omar.genesis.academic_program.model.AcademicProgram
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AcademicProgramRepository: JpaRepository<AcademicProgram, Long>{
}