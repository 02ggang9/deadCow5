package deadCow5.deadCow5.alarm.repository;

import deadCow5.deadCow5.alarm.entity.Alarm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlarmRepository extends JpaRepository<Alarm, Long> {



}
