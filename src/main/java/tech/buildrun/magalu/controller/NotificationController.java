package tech.buildrun.magalu.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.buildrun.magalu.controller.dto.ScheduleNotificationDto;
import tech.buildrun.magalu.entity.Notification;
import tech.buildrun.magalu.service.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<Void> scheduleNotification(@RequestBody ScheduleNotificationDto scheduleNotificationDto) {

        notificationService.schedule(scheduleNotificationDto);

        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotification(@PathVariable("id") Long notificationId) {
        var notification = notificationService.findById(notificationId);

        return notification.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelNotification(@PathVariable("id") Long notificationId) {
        var notification = notificationService.cancelNotification(notificationId);

        if (notification.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }


}
