package com.example.notification_service.entity;

import com.example.notification_service.enums.NotificationType;
// import com.example.notification_service.kafka.order.OrderConfirmation; // Removed due to missing package/class
// import com.example.notification_service.kafka.payment.PaymentNotificationRequest; // Removed due to missing package/class
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Notification {
    private String id;
    private NotificationType type;
    private LocalDateTime notificationDate;
    // private OrderConfirmation orderConfirmation; // Removed due to missing class
    // private PaymentNotificationRequest paymentConfirmation; // Removed due to missing class
}