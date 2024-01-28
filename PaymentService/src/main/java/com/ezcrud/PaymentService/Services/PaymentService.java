package com.ezcrud.PaymentService.Services;

import com.ezcrud.PaymentService.Models.PaymentRequest;
import com.ezcrud.PaymentService.Models.PaymentResponse;

public interface PaymentService {

    PaymentResponse make(PaymentRequest paymentRequest);

    PaymentResponse show(Long orderId);
}
