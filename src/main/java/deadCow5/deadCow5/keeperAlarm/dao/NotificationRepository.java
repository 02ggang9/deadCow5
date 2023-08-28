package deadCow5.deadCow5.keeperAlarm.dao;

import deadCow5.deadCow5.keeperAlarm.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
