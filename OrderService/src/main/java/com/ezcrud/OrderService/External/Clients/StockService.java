package com.ezcrud.OrderService.External.Clients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "STOCK-SERVICE", url = "http://localhost:8080/stocks")
public interface StockService {

}

