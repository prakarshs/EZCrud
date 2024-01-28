package com.ezcrud.OrderService.External.Classes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentResponse {
    private String message;
    private Long paymentId;
    private Long orderId;
    private String orderRefCode;
    private Long paymentAmount;
    private String paymentMode;
}
