package efub.team4.backend_eweather.domain.calendar2.service;

import efub.team4.backend_eweather.domain.bear.Entity.Bear;
import efub.team4.backend_eweather.domain.bear.repository.BearRepository;
import efub.team4.backend_eweather.domain.calendar2.dto.CalendarRequestDto;
import efub.team4.backend_eweather.domain.calendar2.dto.CalendarResponseDto;
import efub.team4.backend_eweather.domain.calendar2.entity.Calendar;
import efub.team4.backend_eweather.domain.calendar2.repository.CalendarRepository;
import efub.team4.backend_eweather.domain.user.entity.User;
import efub.team4.backend_eweather.domain.user.repository.UserRepository;
import efub.team4.backend_eweather.domain.weather.dto.CalendarWeatherResponseDto;
import efub.team4.backend_eweather.domain.weather.service.OpenWeatherAPI;
import efub.team4.backend_eweather.global.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CalendarService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final BearRepository bearRepository;

    @Autowired
    private final CalendarRepository calendarRepository;

    @Autowired
    private final OpenWeatherAPI openWeatherAPI;

    public CalendarResponseDto buildResponse(Calendar calendar){
        return new CalendarResponseDto(calendar);
    }

    public CalendarResponseDto savePost(SessionUser sessionUser, CalendarRequestDto calendarRequestDto, UUID bearId) throws IOException, ParseException {
        User user = userRepository.findByEmail(sessionUser.getEmail());
        Bear bear = bearRepository.findById(bearId).get();
        CalendarWeatherResponseDto weatherdto = openWeatherAPI.findCalendarWeather();
        Calendar calendar = Calendar.builder()
                .user(user)
                .bear(bear)
                .content(calendarRequestDto.getContext())
                .icon(weatherdto.getSky())
                .tmp(weatherdto.getTmp())
                .tmx(weatherdto.getTmx())
                .tmn(weatherdto.getTmn())
                .pop(weatherdto.getPop())
                .build();
        Calendar resCalendar = calendarRepository.save(calendar);
        return buildResponse(resCalendar);
    }
}
