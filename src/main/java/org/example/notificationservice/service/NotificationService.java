package org.example.notificationservice.service;

import org.example.notificationservice.model.Notification;

public interface NotificationService {
    Notification createNotification(String opportunityId, String type, String message);

    void sendNotification(Notification notification);
}
