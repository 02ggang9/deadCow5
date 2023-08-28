package deadCow5.deadCow5.member.entity;

import deadCow5.deadCow5.keeperAlarm.entity.Notification;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany
    private final List<Notification> notifications = new ArrayList<>();

    @Builder
    private Member(String name) {
        this.name = name;
    }


}
