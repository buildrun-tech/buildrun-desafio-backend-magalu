package tech.buildrun.magalu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.buildrun.magalu.entity.Notification;
import tech.buildrun.magalu.entity.Status;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByStatusInAndDateTimeBefore(List<Status> entity, LocalDateTime dateTime);
}
