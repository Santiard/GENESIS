package com.omar.genesis.subject.repository

import com.omar.genesis.subject.model.Subject
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SubjectRepository: JpaRepository<Subject, Long> {
}