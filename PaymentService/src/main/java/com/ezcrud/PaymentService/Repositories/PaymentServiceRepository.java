package com.ezcrud.PaymentService.Repositories;

import com.ezcrud.PaymentService.Entities.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentServiceRepository extends JpaRepository<Payments, Long> {
}
