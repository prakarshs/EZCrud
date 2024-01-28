package com.ezcrud.OrderService.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "ORDER_DETAILS")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @Column(name = "ORDER_REF_CODE")
    private String orderRefCode;
    @Column(name = "STOCK_ID")
    private Long stockId;
    @Column(name = "ORDER_QUANTITY")
    private Long orderQuantity;
    @Column(name = "ORDER_TIME")
    private Instant orderTime;
    @Column(name = "ORDER_STATUS")
    private String orderStatus;
}
