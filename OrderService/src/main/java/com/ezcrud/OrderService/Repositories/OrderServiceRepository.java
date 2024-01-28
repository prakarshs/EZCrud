package com.ezcrud.OrderService.Repositories;

import com.ezcrud.OrderService.Entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderServiceRepository extends JpaRepository<Orders,Long> {

    Orders findByorderRefCode(String orderRefCode);
}

