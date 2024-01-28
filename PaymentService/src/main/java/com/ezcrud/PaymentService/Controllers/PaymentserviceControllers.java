package com.ezcrud.PaymentService.Controllers;

import com.ezcrud.PaymentService.Models.PaymentRequest;
import com.ezcrud.PaymentService.Models.PaymentResponse;
import com.ezcrud.PaymentService.Services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentserviceControllers {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/make")
    private ResponseEntity<PaymentResponse> make(@RequestBody PaymentRequest paymentRequest){
        return new ResponseEntity<>(paymentService.make(paymentRequest), HttpStatus.OK);
    }
    @GetMapping("/show/{id}")
    private ResponseEntity<PaymentResponse> show(@PathVariable("id") Long orderId){
        return new ResponseEntity<>(paymentService.show(orderId), HttpStatus.OK);
    }
}
