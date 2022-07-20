package efub.team4.backend_eweather.domain.dayNight.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Entity
public class DayNight {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(length = 16)
    private UUID id;

    @Size(max = 50)
    @NotEmpty
    private String timeName;

    @DateTimeFormat(pattern = "HH:mm:ss")
    @Column(columnDefinition = "TIME")
    @NotNull
    private LocalTime time;

    @Builder
    public DayNight(String timeName, LocalTime time) {
        this.timeName = timeName;
        this.time = time;
    }
}
