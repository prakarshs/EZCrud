package com.ezcrud.OrderService.Services;

import com.ezcrud.OrderService.Models.OrderRequest;
import com.ezcrud.OrderService.Models.OrderResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class OrderServiceIMPL implements OrderService{
    @Override
    public OrderResponse create(OrderRequest orderRequest) {
        return null;
    }
}
