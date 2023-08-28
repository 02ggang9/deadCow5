package deadCow5.deadCow5.keeperAlarm.entity.embedded;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NotificationType {

  포인트선물(1),
  퍼블봇(2),
  팔로잉(3),
  ;

  private final long id;

}
