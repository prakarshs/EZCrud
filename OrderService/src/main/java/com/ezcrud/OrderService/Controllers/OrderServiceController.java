package com.ezcrud.OrderService.Controllers;

import com.ezcrud.OrderService.Models.OrderRequest;
import com.ezcrud.OrderService.Models.OrderResponse;
import com.ezcrud.OrderService.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderServiceController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    private ResponseEntity<OrderResponse> create(@RequestBody OrderRequest orderRequest){
        return new ResponseEntity<>(orderService.addCart(orderRequest), HttpStatus.OK);
    }

}
