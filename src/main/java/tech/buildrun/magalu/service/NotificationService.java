package tech.buildrun.magalu.service;

import org.springframework.stereotype.Service;
import tech.buildrun.magalu.controller.dto.ScheduleNotificationDto;
import tech.buildrun.magalu.entity.Notification;
import tech.buildrun.magalu.entity.Status;
import tech.buildrun.magalu.repository.NotificationRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void schedule(ScheduleNotificationDto scheduleNotificationDto) {

        var entity = scheduleNotificationDto.toNotification();

        notificationRepository.save(entity);
    }

    public void checkAndSend(LocalDateTime dateTime) {
        var notifications = notificationRepository.findByStatusInAndDateTimeBefore(
                List.of(Status.Values.PENDING.toEntity(), Status.Values.ERROR.toEntity()),
                dateTime
        );

        notifications.forEach(this::sendNotification);
    }

    private void sendNotification(Notification notification) {

        // code to send notification...

        notification.setStatus(Status.Values.SUCCESS.toEntity());
        notificationRepository.save(notification);
    }

    public Optional<Notification> findById(Long notificationId) {
        return notificationRepository.findById(notificationId);
    }

    public Optional<Notification> cancelNotification(Long notificationId) {
        var notification = findById(notificationId);

        if (notification.isPresent()) {
            notification.get().setStatus(Status.Values.CANCELED.toEntity());
            notificationRepository.save(notification.get());
        }

        return notification;
    }
}
