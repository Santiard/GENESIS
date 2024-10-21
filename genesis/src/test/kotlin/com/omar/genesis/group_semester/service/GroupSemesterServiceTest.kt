import com.omar.genesis.group_semester.model.GroupSemester
import com.omar.genesis.group_semester.repository.GroupSemesterRepository
import com.omar.genesis.group_semester.service.GroupSemesterService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import java.time.Year

class GroupSemesterServiceTest {

    private val repository: GroupSemesterRepository = mock(GroupSemesterRepository::class.java)
    private val service = GroupSemesterService(repository)

    @Test
    fun getByUserCode_returnsGroupSemesters() {
        val code = "user123"
        val expected = listOf(GroupSemester(), GroupSemester())
        `when`(repository.getByUserCode(code)).thenReturn(expected)

        val result = service.getByUserCode(code)

        assertEquals(expected, result)
    }

    @Test
    fun getByUserCode_returnsEmptyListWhenNoGroupSemesters() {
        val code = "user123"
        `when`(repository.getByUserCode(code)).thenReturn(emptyList())

        val result = service.getByUserCode(code)

        assertEquals(emptyList<GroupSemester>(), result)
    }

    @Test
    fun getByUserCodeYearPeriod_returnsGroupSemesters() {
        val code = "user123"
        val year = 2023
        val period = 'A'
        val expected = listOf(GroupSemester(), GroupSemester())
        `when`(repository.getByUserCodeYearPeriod(code, Year.of(year), period)).thenReturn(expected)

        val result = service.getByUserCodeYearPeriod(code, year, period)

        assertEquals(expected, result)
    }

    @Test
    fun getByUserCodeYearPeriod_returnsEmptyListWhenNoGroupSemesters() {
        val code = "user123"
        val year = 2023
        val period = 'A'
        `when`(repository.getByUserCodeYearPeriod(code, Year.of(year), period)).thenReturn(emptyList())

        val result = service.getByUserCodeYearPeriod(code, year, period)

        assertEquals(emptyList<GroupSemester>(), result)
    }
}