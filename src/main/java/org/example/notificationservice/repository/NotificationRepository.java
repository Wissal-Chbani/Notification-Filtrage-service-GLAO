package org.example.notificationservice.repository;

import org.example.notificationservice.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends MongoRepository<Notification, String> {

    // Find notifications by opportunityId
    List<Notification> findByOpportunityId(String opportunityId);

    // Find notifications by type
    List<Notification> findByType(String type);
}
