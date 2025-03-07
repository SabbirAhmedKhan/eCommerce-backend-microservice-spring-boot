package com.sabbir.notification.repository;

import com.sabbir.notification.model.entity.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification, String> {
}
