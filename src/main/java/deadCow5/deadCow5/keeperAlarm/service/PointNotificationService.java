package deadCow5.deadCow5.keeperAlarm.service;

import deadCow5.deadCow5.keeperAlarm.dao.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PointNotificationService {

  private final NotificationRepository notificationRepository;


}
