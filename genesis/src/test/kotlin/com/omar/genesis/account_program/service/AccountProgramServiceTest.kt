package com.omar.genesis.account_program.service

import com.omar.genesis.account_program.model.AccountProgram
import com.omar.genesis.account_program.repository.AccountProgramRepository
import com.omar.genesis.subject.model.Subject
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class AccountProgramServiceTest {

    private lateinit var repository: AccountProgramRepository
    private lateinit var service: AccountProgramService

    @BeforeEach
    fun setUp() {
        repository = mock(AccountProgramRepository::class.java)
        service = AccountProgramService(repository)
    }

    @Test
    fun loginWithValidCredentialsReturnsAccountProgram() {
        val code = "validCode"
        val password = "validPassword"
        val accountProgram = AccountProgram()
        `when`(repository.login(code, password)).thenReturn(accountProgram)

        val result = service.login(code, password)

        assertNotNull(result)
        assertEquals(accountProgram, result)
    }

    @Test
    fun loginWithInvalidCredentialsReturnsNull() {
        val code = "invalidCode"
        val password = "invalidPassword"
        `when`(repository.login(code, password)).thenReturn(null)

        val result = service.login(code, password)

        assertNull(result)
    }

    @Test
    fun updateIcfesWithValidData() {
        val code = "validCode"
        val icfes = byteArrayOf(1, 2, 3)

        service.updateIcfes(code, icfes)

        verify(repository).updateIcfes(code, icfes)
    }

    @Test
    fun updateRecordWithValidData() {
        val code = "validCode"
        val record = byteArrayOf(4, 5, 6)

        service.updateRecord(code, record)

        verify(repository).updateRecord(code, record)
    }

    @Test
    fun updateCertificateWithValidData() {
        val code = "validCode"
        val certificate = byteArrayOf(7, 8, 9)

        service.updateCertificate(code, certificate)

        verify(repository).updateCertificate(code, certificate)
    }

    @Test
    fun getCurriculumWithValidCodeReturnsSubjects() {
        val code = "validCode"
        val subjects = listOf(Subject(), Subject())
        `when`(repository.getCurriculum(code)).thenReturn(subjects)

        val result = service.getCurriculum(code)

        assertNotNull(result)
        assertEquals(subjects.size, result.size)
    }

    @Test
    fun getCurriculumWithInvalidCodeReturnsEmptyList() {
        val code = "invalidCode"
        `when`(repository.getCurriculum(code)).thenReturn(emptyList())

        val result = service.getCurriculum(code)

        assertNotNull(result)
        assertTrue(result.isEmpty())
    }
}