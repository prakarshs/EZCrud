package com.ezcrud.OrderService.Models;

import com.ezcrud.OrderService.Entities.Orders;
import com.ezcrud.OrderService.External.Classes.Payments;
import com.ezcrud.OrderService.External.Classes.Stocks;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderShow {
    private String message;
    private Stocks orderedStockDetails;
    private Orders orderDetails;
    private Payments paymentDetails;
}
