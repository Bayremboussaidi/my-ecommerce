package com.example.notification_service.kafka.order;

// TODO: Update the import path below to the correct package where PaymentMethod is defined
// Example: import com.example.common.enums.PaymentMethod;
import com.example.common.enums.PaymentMethod;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderConfirmation {
    private String orderReference;
    private BigDecimal totalAmount;
    private PaymentMethod paymentMethod;
    private CustomerResponse customer;
    private List<Product> products;
}
