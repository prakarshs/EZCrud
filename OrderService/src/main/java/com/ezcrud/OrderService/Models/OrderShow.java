package com.ezcrud.OrderService.Models;

import com.ezcrud.OrderService.Entities.Orders;
import com.ezcrud.OrderService.External.Classes.Stocks;
import jakarta.persistence.criteria.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderShow {
    private String message;
    private Stocks orderedStockDetails;
    private Orders orderDetails;
}
