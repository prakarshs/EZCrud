package com.ezcrud.PaymentService.Services;

import com.ezcrud.PaymentService.Entities.Payments;
import com.ezcrud.PaymentService.Errors.CustomError;
import com.ezcrud.PaymentService.Models.Constants;
import com.ezcrud.PaymentService.Models.PaymentRequest;
import com.ezcrud.PaymentService.Models.PaymentResponse;
import com.ezcrud.PaymentService.Repositories.PaymentServiceRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PaymentServiceIMPL implements PaymentService{

    @Autowired
    private PaymentServiceRepository paymentServiceRepository;
    @Override
    public PaymentResponse make(PaymentRequest paymentRequest) {
        log.info("MAKING PAYMENT");
        Payments payments = Payments.builder()
                .orderId(paymentRequest.getOrderId())
                .orderRefCode(paymentRequest.getOrderRefCode())
                .paymentAmount(paymentRequest.getPaymentAmount())
                .paymentMode(paymentRequest.getPaymentMode())
                .build();

        paymentServiceRepository.save(payments);


        return PaymentResponse.builder()
                .message("PAYMENT HAS BEEN DONE !")
                .orderId(payments.getOrderId())
                .paymentId(payments.getPaymentId())
                .paymentAmount(payments.getPaymentAmount())
                .orderRefCode(payments.getOrderRefCode())
                .paymentMode(payments.getPaymentMode())
                .build();
    }

    @Override
    public PaymentResponse show(Long orderId) {
        Payments payments;
        payments = paymentServiceRepository.findById(orderId).orElseThrow(()->new CustomError(Constants.ORDER_ID_DOESNT_EXIST, Constants.TRY_WITH_A_DIFFERENT_ORDER_ID));

        return PaymentResponse.builder()
                .message("PAYMENT HAS BEEN FETCHED !")
                .paymentId(payments.getPaymentId())
                .paymentAmount(payments.getPaymentAmount())
                .orderRefCode(payments.getOrderRefCode())
                .paymentMode(payments.getPaymentMode())
                .build();
    }
}
