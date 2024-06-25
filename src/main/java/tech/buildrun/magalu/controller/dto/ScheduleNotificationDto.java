package tech.buildrun.magalu.controller.dto;

import tech.buildrun.magalu.entity.Channel;
import tech.buildrun.magalu.entity.Notification;
import tech.buildrun.magalu.entity.Status;

import java.time.LocalDateTime;

public record ScheduleNotificationDto(LocalDateTime dateTime,
                                      String destination,
                                      String message,
                                      Channel.Values channel) {

    public Notification toNotification() {
        return new Notification(
            dateTime,
            destination,
            message,
            Status.Values.PENDING.toEntity(),
            channel.toEntity()
        );
    }
}
