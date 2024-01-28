package com.ezcrud.PaymentService.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PAYMENT_DETAILS")
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    @Column(name = "ORDER_REF_CODE")
    private String orderRefCode;
    @Column(name = "ORDER_ID")
    private Long orderId;
    @Column(name = "PAYMENT_AMOUNT")
    private Long paymentAmount;
    @Column(name = "PAYMENT_MODE")
    private String paymentMode;
}
