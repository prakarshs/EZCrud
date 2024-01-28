package com.ezcrud.OrderService.External.Clients;

import com.ezcrud.OrderService.External.Classes.StockResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "STOCK-SERVICE", url = "http://localhost:8080/stocks")
public interface StockService {

    @PutMapping("/reduce/{id}/{quantity}")
    ResponseEntity<StockResponse> reduce(@PathVariable("id") Long stockId, @PathVariable("quantity") Long quantity);
}

