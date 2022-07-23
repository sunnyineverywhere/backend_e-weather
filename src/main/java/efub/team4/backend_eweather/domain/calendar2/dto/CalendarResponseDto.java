package efub.team4.backend_eweather.domain.calendar2.dto;

import efub.team4.backend_eweather.domain.bear.Entity.Bear;
import efub.team4.backend_eweather.domain.calendar2.entity.Calendar;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class CalendarResponseDto {
    private Long id;
    private String userEmail;
    private UUID bearId;
    private String content;
    private LocalDateTime createdOn;

    @Builder
    public CalendarResponseDto(Calendar entity) {
        this.id = entity.getId();
        this.userEmail = entity.getUser().getEmail();
        this.bearId = entity.getBear().getId();
        this.content = entity.getContent();
        this.createdOn = entity.getCreatedOn();
    }


}
