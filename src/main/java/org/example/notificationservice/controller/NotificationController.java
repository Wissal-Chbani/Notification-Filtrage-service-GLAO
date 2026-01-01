package org.example.notificationservice.controller;

import org.example.notificationservice.model.Notification;
import org.example.notificationservice.repository.NotificationRepository;
import org.example.notificationservice.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;
    private final NotificationRepository notificationRepository;

    public NotificationController(NotificationService notificationService,
                                  NotificationRepository notificationRepository) {
        this.notificationService = notificationService;
        this.notificationRepository = notificationRepository;
    }

    // Create a notification
    @PostMapping
    public ResponseEntity<Notification> createNotification(
            @RequestParam String opportunityId,
            @RequestParam String type,
            @RequestParam String message) {

        Notification notification =
                notificationService.createNotification(opportunityId, type, message);

        notificationService.sendNotification(notification);

        return ResponseEntity.ok(notification);
    }

    // Get all notifications
    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications() {
        return ResponseEntity.ok(notificationRepository.findAll());
    }

    // Get notifications by opportunity
    @GetMapping("/opportunity/{id}")
    public ResponseEntity<List<Notification>> getByOpportunity(
            @PathVariable String id) {

        return ResponseEntity.ok(
                notificationRepository.findByOpportunityId(id)
        );
    }
}
