import com.omar.genesis.clase.model.dtos.Clase
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClaseRepository : JpaRepository<Clase, Long> {
}