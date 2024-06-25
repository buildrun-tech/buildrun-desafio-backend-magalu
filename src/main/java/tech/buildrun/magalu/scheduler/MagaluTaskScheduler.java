package tech.buildrun.magalu.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tech.buildrun.magalu.service.NotificationService;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class MagaluTaskScheduler {

    private Logger logger = LoggerFactory.getLogger(MagaluTaskScheduler.class);

    private final NotificationService notificationService;

    public MagaluTaskScheduler(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void checkTasks() {
        var dateTime = LocalDateTime.now();
        logger.info("Checking tasks at {}", dateTime);
        notificationService.checkAndSend(dateTime);
    }

}
