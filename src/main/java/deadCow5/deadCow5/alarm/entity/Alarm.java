package deadCow5.deadCow5.alarm.entity;

import deadCow5.deadCow5.BaseTimeEntity;
import deadCow5.deadCow5.member.entity.Member;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Alarm extends BaseTimeEntity {

    private static final int MAX_TITLE_LENGTH = 250;

    @Id
    @GeneratedValue
    @Column(name = "alarm_id")
    private Long id;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "title", nullable = false, length = MAX_TITLE_LENGTH)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "url", nullable = false)
    private String url;


    @Builder
    private Alarm(Long memberId, String title, String content, String url) {
        this.memberId = memberId;
        this.title = title;
        this.content = content;
        this.url = url;
    }

}
