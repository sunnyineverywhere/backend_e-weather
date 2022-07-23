package efub.team4.backend_eweather.domain.bear.Entity;

import efub.team4.backend_eweather.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;


/*
	`id` varchar(36) primary key,
    `user_id` varchar(36),
	`tmp` varchar(255),
    `sky` varchar(255),
    `pty` varchar(255),
    `season` varchar(255),
    foreign key(user_id) references user(id)
 */

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Bear {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name ="uuid2", strategy = "uuid2")
    @Column(length = 16)
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column
    private String tmp;

    @Column
    private String sky;

    @Column
    private String pty;

    @Column
    private String season;

    @Builder
    public Bear(UUID id, User user, String tmp, String sky, String pty, String season) {
        this.id = UUID.randomUUID();
        this.user = user;
        this.tmp = tmp;
        this.sky = sky;
        this.pty = pty;
        this.season = season;
    }
}
