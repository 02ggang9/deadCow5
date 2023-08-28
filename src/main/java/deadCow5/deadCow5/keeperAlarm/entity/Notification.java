package deadCow5.deadCow5.keeperAlarm.entity;

import deadCow5.deadCow5.keeperAlarm.entity.embedded.NotificationType;
import deadCow5.deadCow5.member.entity.Member;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "notification")
public class Notification {

  @Id
  @GeneratedValue
  @Column(name = "id", nullable = false, updatable = false)
  private Long id;

  @Column(name = "content", nullable = false, updatable = false)
  private String content;

  @Column(name = "url", nullable = false, updatable = false)
  private String url;

  @Enumerated
  @Column(name = "notification_type", nullable = false, updatable = false)
  private NotificationType notificationType;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_id")
  private Member member;

  @Column(name = "isRead", nullable = false, updatable = true)
  private Boolean isRead;

  @Builder
  public Notification(String content, String url, NotificationType notificationType,
      Member member, Boolean isRead) {
    this.content = content;
    this.url = url;
    this.notificationType = notificationType;
    this.member = member;
    this.isRead = isRead;
  }

}
