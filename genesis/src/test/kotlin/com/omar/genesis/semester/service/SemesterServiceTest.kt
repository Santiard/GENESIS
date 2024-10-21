import com.omar.genesis.semester.model.Semester
import com.omar.genesis.semester.repository.SemesterRepository
import com.omar.genesis.semester.service.SemesterService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

class SemesterServiceTest {

    private val repository: SemesterRepository = mock(SemesterRepository::class.java)
    private val service = SemesterService(repository)

    @Test
    fun getSemestersByCode_returnsSemesters() {
        val code = "user123"
        val expected = listOf(Semester(), Semester())
        `when`(repository.getSemestersByCode(code)).thenReturn(expected)

        val result = service.getSemestersByCode(code)

        assertEquals(expected, result)
    }

    @Test
    fun getSemestersByCode_returnsEmptyListWhenNoSemesters() {
        val code = "user123"
        `when`(repository.getSemestersByCode(code)).thenReturn(emptyList())

        val result = service.getSemestersByCode(code)

        assertEquals(emptyList<Semester>(), result)
    }

    @Test
    fun getActiveSemesterByCode_returnsActiveSemester() {
        val code = "user123"
        val expected = Semester()
        `when`(repository.getActiveSemester(code)).thenReturn(expected)

        val result = service.getActiveSemesterByCode(code)

        assertEquals(expected, result)
    }

    @Test
    fun getActiveSemesterByCode_returnsNullWhenNoActiveSemester() {
        val code = "user123"
        `when`(repository.getActiveSemester(code)).thenReturn(null)

        val result = service.getActiveSemesterByCode(code)

        assertEquals(null, result)
    }

    @Test
    fun getNonActiveSemesterByCode_returnsNonActiveSemesters() {
        val code = "user123"
        val expected = listOf(Semester(), Semester())
        `when`(repository.getNonActiveSemester(code)).thenReturn(expected)

        val result = service.getNonActiveSemesterByCode(code)

        assertEquals(expected, result)
    }

    @Test
    fun getNonActiveSemesterByCode_returnsEmptyListWhenNoNonActiveSemesters() {
        val code = "user123"
        `when`(repository.getNonActiveSemester(code)).thenReturn(emptyList())

        val result = service.getNonActiveSemesterByCode(code)

        assertEquals(emptyList<Semester>(), result)
    }

    @Test
    fun paySemester_callsRepositoryPaySemester() {
        val id = 1L
        service.paySemester(id)
        verify(repository).paySemester(id)
    }
}