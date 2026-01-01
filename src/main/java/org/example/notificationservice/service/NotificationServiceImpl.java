package org.example.notificationservice.service;

import org.example.notificationservice.model.Notification;
import org.example.notificationservice.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Notification createNotification(String opportunityId, String type, String message) {

        Notification notification = Notification.builder()
                .opportunityId(opportunityId)
                .type(type)
                .message(message)
                .sentAt(LocalDateTime.now())
                .build();

        return notificationRepository.save(notification);
    }

    @Override
    public void sendNotification(Notification notification) {
        // Simulation (real email/push later)
        System.out.println("Sending " + notification.getType()
                + " notification: " + notification.getMessage());
    }
}