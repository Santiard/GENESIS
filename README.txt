PRUEBAS:

##Introduccion:
Este proyecto de la aplicacion web de genesis fue realizado con kotlin para su backend y Angular para su frontend.
Este document odescribe las pruebas realizadas a los servicios usados para el funcionamiento de la aplicacion.

##PRUEBAS:

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
        when(repository.login(code, password)).thenReturn(accountProgram)

        val result = service.login(code, password)

        assertNotNull(result)
        assertEquals(accountProgram, result)
    }

    @Test
    fun loginWithInvalidCredentialsReturnsNull() {
        val code = "invalidCode"
        val password = "invalidPassword"
        when(repository.login(code, password)).thenReturn(null)

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
        when(repository.getCurriculum(code)).thenReturn(subjects)

        val result = service.getCurriculum(code)

        assertNotNull(result)
        assertEquals(subjects.size, result.size)
    }

    @Test
    fun getCurriculumWithInvalidCodeReturnsEmptyList() {
        val code = "invalidCode"
        when(repository.getCurriculum(code)).thenReturn(emptyList())

        val result = service.getCurriculum(code)

        assertNotNull(result)
        assertTrue(result.isEmpty())
    }

##RESULTADO:

> Task :test

BUILD SUCCESSFUL in 32s

5 actionable tasks: 3 executed, 2 up-to-date

11:29:08 a. m.: Execution finished ‘:test --tests "com.omar.genesis.account_program.service.AccountProgramServiceTest"’.



##prueba2

class GroupSemesterServiceTest {

    private val repository: GroupSemesterRepository = mock(GroupSemesterRepository::class.java)
    private val service = GroupSemesterService(repository)

    @Test
    fun getByUserCode_returnsGroupSemesters() {
        val code = "user123"
        val expected = listOf(GroupSemester(), GroupSemester())
        when(repository.getByUserCode(code)).thenReturn(expected)

        val result = service.getByUserCode(code)

        assertEquals(expected, result)
    }

    @Test
    fun getByUserCode_returnsEmptyListWhenNoGroupSemesters() {
        val code = "user123"
        when(repository.getByUserCode(code)).thenReturn(emptyList())

        val result = service.getByUserCode(code)

        assertEquals(emptyList<GroupSemester>(), result)
    }

    @Test
    fun getByUserCodeYearPeriod_returnsGroupSemesters() {
        val code = "user123"
        val year = 2023
        val period = 'A'
        val expected = listOf(GroupSemester(), GroupSemester())
        when(repository.getByUserCodeYearPeriod(code, Year.of(year), period)).thenReturn(expected)

        val result = service.getByUserCodeYearPeriod(code, year, period)

        assertEquals(expected, result)
    }

    @Test
    fun getByUserCodeYearPeriod_returnsEmptyListWhenNoGroupSemesters() {
        val code = "user123"
        val year = 2023
        val period = 'A'
        when(repository.getByUserCodeYearPeriod(code, Year.of(year), period)).thenReturn(emptyList())

        val result = service.getByUserCodeYearPeriod(code, year, period)

        assertEquals(emptyList<GroupSemester>(), result)
    }}

##resultado:

> Task :test

BUILD SUCCESSFUL in 3s

5 actionable tasks: 2 executed, 3 up-to-date

11:52:06 a. m.: Execution finished ':test --tests "GroupSemesterServiceTest.getByUserCode_returnsEmptyListWhenNoGroupSemesters"'.

​
​

##3
class SemesterServiceTest {

    private val repository: SemesterRepository = mock(SemesterRepository::class.java)
    private val service = SemesterService(repository)

    @Test
    fun getSemestersByCode_returnsSemesters() {
        val code = "user123"
        val expected = listOf(Semester(), Semester())
        when(repository.getSemestersByCode(code)).thenReturn(expected)

        val result = service.getSemestersByCode(code)

        assertEquals(expected, result)
    }

    @Test
    fun getSemestersByCode_returnsEmptyListWhenNoSemesters() {
        val code = "user123"
        when(repository.getSemestersByCode(code)).thenReturn(emptyList())

        val result = service.getSemestersByCode(code)

        assertEquals(emptyList<Semester>(), result)
    }

    @Test
    fun getActiveSemesterByCode_returnsActiveSemester() {
        val code = "user123"
        val expected = Semester()
        when(repository.getActiveSemester(code)).thenReturn(expected)

        val result = service.getActiveSemesterByCode(code)

        assertEquals(expected, result)
    }

    @Test
    fun getActiveSemesterByCode_returnsNullWhenNoActiveSemester() {
        val code = "user123"
        when(repository.getActiveSemester(code)).thenReturn(null)

        val result = service.getActiveSemesterByCode(code)

        assertEquals(null, result)
    }

    @Test
    fun getNonActiveSemesterByCode_returnsNonActiveSemesters() {
        val code = "user123"
        val expected = listOf(Semester(), Semester())
        when(repository.getNonActiveSemester(code)).thenReturn(expected)

        val result = service.getNonActiveSemesterByCode(code)

        assertEquals(expected, result)
    }

    @Test
    fun getNonActiveSemesterByCode_returnsEmptyListWhenNoNonActiveSemesters() {
        val code = "user123"
        when(repository.getNonActiveSemester(code)).thenReturn(emptyList())

        val result = service.getNonActiveSemesterByCode(code)

        assertEquals(emptyList<Semester>(), result)
    }

    @Test
    fun paySemester_callsRepositoryPaySemester() {
        val id = 1L
        service.paySemester(id)
        verify(repository).paySemester(id)
    }}

##resultado:

> Task : test
BUILD SUCCESSFUL in 4s
5 actionable tasks: 2 executed, 3 up-to-date
11:59:47 a. m.: Execution finished 'test - tests "SemesterServiceTest"'.