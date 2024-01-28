package com.ezcrud.OrderService.Services;

import com.ezcrud.OrderService.Models.OrderRequest;
import com.ezcrud.OrderService.Models.OrderResponse;

public interface OrderService {
    OrderResponse create(OrderRequest orderRequest);
}
