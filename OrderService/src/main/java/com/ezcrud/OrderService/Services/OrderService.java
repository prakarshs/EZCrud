package com.ezcrud.OrderService.Services;

import com.ezcrud.OrderService.Models.OrderRequest;
import com.ezcrud.OrderService.Models.OrderResponse;
import com.ezcrud.OrderService.Models.OrderShow;
import com.ezcrud.OrderService.Models.PlaceOrderRequest;

public interface OrderService {

    OrderResponse addCart(OrderRequest orderRequest);

    OrderShow show(Long orderId);

    OrderResponse place(PlaceOrderRequest placeOrderRequest);
}
