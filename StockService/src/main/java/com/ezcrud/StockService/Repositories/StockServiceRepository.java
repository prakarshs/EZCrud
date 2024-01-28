package com.ezcrud.StockService.Repositories;

import com.ezcrud.StockService.Entities.Stocks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockServiceRepository extends JpaRepository<Stocks,Long> {
}
