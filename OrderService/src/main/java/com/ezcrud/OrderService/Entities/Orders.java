package com.ezcrud.OrderService.Entities;

import com.ezcrud.OrderService.Models.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

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
    @Column(name = "STOCK_ID")
    private Long stockId;
    @Column(name = "ORDER_QUANTITY")
    private Long orderQuantity;
    @Column(name = "ORDER_TIME")
    private Instant orderTime;
    @Column(name = "ORDER_STATUS")
    private OrderStatus orderStatus;
}
