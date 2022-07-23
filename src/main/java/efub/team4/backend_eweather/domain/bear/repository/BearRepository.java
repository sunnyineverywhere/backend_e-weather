package efub.team4.backend_eweather.domain.bear.repository;

import efub.team4.backend_eweather.domain.bear.Entity.Bear;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BearRepository extends JpaRepository<Bear, UUID> {
}
