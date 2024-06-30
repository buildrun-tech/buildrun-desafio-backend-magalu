package tech.buildrun.magalums.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.buildrun.magalums.entity.Notification;
import tech.buildrun.magalums.entity.Status;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByStatusInAndDateTimeBefore(List<Status> status, LocalDateTime dateTime);
}
