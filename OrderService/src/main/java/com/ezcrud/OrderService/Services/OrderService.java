package com.ezcrud.OrderService.Services;

import com.ezcrud.OrderService.Models.OrderRequest;
import com.ezcrud.OrderService.Models.OrderResponse;
import com.ezcrud.OrderService.Models.OrderShow;

public interface OrderService {

    OrderResponse addCart(OrderRequest orderRequest);

    OrderShow show(Long orderId);
}
