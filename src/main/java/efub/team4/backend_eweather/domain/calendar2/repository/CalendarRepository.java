package efub.team4.backend_eweather.domain.calendar2.repository;

import efub.team4.backend_eweather.domain.calendar2.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarRepository extends JpaRepository<Calendar, Long> {
}
