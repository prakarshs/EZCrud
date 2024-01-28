package com.ezcrud.OrderService.Models;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {
    private Long orderId;
    private Long stockId;
    private Long orderQuantity;
    private Instant orderTime;
    private OrderStatus orderStatus;
}
