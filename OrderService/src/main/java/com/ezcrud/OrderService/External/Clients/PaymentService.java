package com.ezcrud.OrderService.External.Clients;

import com.ezcrud.OrderService.External.Classes.PaymentRequest;
import com.ezcrud.OrderService.External.Classes.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PAYMENT-SERVICE",url = "http://localhost:8082/payments")
public interface PaymentService {
    @PostMapping("/make")
    ResponseEntity<PaymentResponse> make(@RequestBody PaymentRequest paymentRequest);
}
