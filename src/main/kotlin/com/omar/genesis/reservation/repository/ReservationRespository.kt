import com.omar.genesis.reservation.model.reservation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReservationRespository : JpaRepository<Reservation, Long> {
}