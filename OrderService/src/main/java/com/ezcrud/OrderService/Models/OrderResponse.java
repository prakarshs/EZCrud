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
    private String message;
    private Long orderId;
    private String orderRefCode;
    private Long stockId;
    private Long orderQuantity;
    private Instant orderTime;
    private String orderStatus;
}
