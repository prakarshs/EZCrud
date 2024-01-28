package com.ezcrud.OrderService.Services;

import com.ezcrud.OrderService.Entities.Orders;
import com.ezcrud.OrderService.External.Classes.Stocks;
import com.ezcrud.OrderService.Models.Constants;
import com.ezcrud.OrderService.Models.OrderRequest;
import com.ezcrud.OrderService.Models.OrderResponse;
import com.ezcrud.OrderService.Repositories.OrderServiceRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;

@Service
@Log4j2
public class OrderServiceIMPL implements OrderService{

    @Autowired
    private OrderServiceRepository orderServiceRepository;

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public OrderResponse addCart(OrderRequest orderRequest) {
        log.info("VALIDATING ORDER STOCKID...");
        Stocks stocks = restTemplate.getForObject("http://localhost:8080/stocks/show/"+orderRequest.getStockId(), Stocks.class);

        Orders orders;

        assert stocks != null;
        if(orderRequest.getOrderQuantity() <= stocks.getStockQuantity()){
            orders = Orders.builder()
                    .stockId(stocks.getStockId())
                    .orderQuantity(orderRequest.getOrderQuantity())
                    .orderTime(Instant.now())
                    .orderStatus(Constants.ADDED_TO_CART)
                    .build();
            orderServiceRepository.save(orders);
        }
        else {
            throw new RuntimeException("ERROR");
        }
        return OrderResponse.builder()
                .message("STOCK ADDED TO CART!")
                .orderId(orders.getOrderId())
                .stockId(orders.getStockId())
                .orderQuantity(orders.getOrderQuantity())
                .orderTime(orders.getOrderTime())
                .orderStatus(orders.getOrderStatus())
                .build();
    }
}
