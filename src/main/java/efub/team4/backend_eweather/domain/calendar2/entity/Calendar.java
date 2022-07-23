package efub.team4.backend_eweather.domain.calendar2.entity;

import efub.team4.backend_eweather.domain.bear.Entity.Bear;
import efub.team4.backend_eweather.domain.user.entity.User;
import efub.team4.backend_eweather.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

/*
	`id` bigint primary key,
    `user_id` varchar(36),
    `bear_id` varchar(36),
    `content` TEXT,
    `icon` varchar(255),
    `tmp` varchar(10),
    `tmx` varchar(10),
    `tmn` varchar(10),
    `pop` varchar(10),
    foreign key(user_id) references user(id),
    foreign key(bear_id) references user(id)
 */

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Calendar extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "bearId")
    private Bear bear;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column
    private String icon;

    @Column
    private String tmp;

    @Column
    private String tmx;

    @Column
    private String tmn;

    @Column
    private String pop;


    @Builder
    public Calendar(Long id, User user, Bear bear, String content, String icon, String tmp, String tmx, String tmn, String pop) {
        this.id = id;
        this.user = user;
        this.bear = bear;
        this.content = content;
        this.icon = icon;
        this.tmp = tmp;
        this.tmx = tmx;
        this.tmn = tmn;
        this.pop = pop;
    }
}
