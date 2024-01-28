package com.ezcrud.OrderService.Controllers;

import com.ezcrud.OrderService.Models.OrderRequest;
import com.ezcrud.OrderService.Models.OrderResponse;
import com.ezcrud.OrderService.Models.OrderShow;
import com.ezcrud.OrderService.Models.PlaceOrderRequest;
import com.ezcrud.OrderService.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderServiceController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    private ResponseEntity<OrderResponse> create(@RequestBody OrderRequest orderRequest){
        return new ResponseEntity<>(orderService.addCart(orderRequest), HttpStatus.OK);
    }
    @PostMapping("/place")
    private ResponseEntity<OrderResponse> place(@RequestBody PlaceOrderRequest placeOrderRequest){
        return new ResponseEntity<>(orderService.place(placeOrderRequest), HttpStatus.OK);
    }

    @GetMapping("/show/{id}")
    private ResponseEntity<OrderShow> show(@PathVariable("id") Long orderId){
        return new ResponseEntity<>(orderService.show(orderId), HttpStatus.OK);
    }

}
