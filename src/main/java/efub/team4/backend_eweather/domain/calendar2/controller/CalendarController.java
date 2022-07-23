package efub.team4.backend_eweather.domain.calendar2.controller;

import efub.team4.backend_eweather.domain.bear.service.BearService;
import efub.team4.backend_eweather.domain.calendar2.dto.CalendarRequestDto;
import efub.team4.backend_eweather.domain.calendar2.dto.CalendarResponseDto;
import efub.team4.backend_eweather.domain.calendar2.service.CalendarService;
import efub.team4.backend_eweather.global.config.auth.LoginUser;
import efub.team4.backend_eweather.global.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CalendarController {

    private final CalendarService calendarService;
    private final BearService bearService;

    @PostMapping
    public CalendarResponseDto postAdd(@LoginUser SessionUser sessionUser, CalendarRequestDto calendarRequestDto) throws IOException, ParseException {
        UUID bearId = bearService.saveBearImage(sessionUser);
        return calendarService.savePost(sessionUser, calendarRequestDto, bearId);
    }

}
