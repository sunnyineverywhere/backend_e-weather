package efub.team4.backend_eweather.domain.calendar2.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CalendarRequestDto {
    private String context;

    @Builder
    public CalendarRequestDto(String context) {
        this.context = context;
    }
}
