package com.ezcrud.StockService.Services;

import com.ezcrud.StockService.Entities.Stocks;
import com.ezcrud.StockService.Models.StockRequest;
import com.ezcrud.StockService.Models.StockResponse;
import com.ezcrud.StockService.Repositories.StockServiceRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class StockServiceIMPL implements StockService{
    @Autowired
    private StockServiceRepository stockServiceRepository;
    @Override
    public StockResponse add(StockRequest stockRequest) {
        log.info("CREATING STOCK...");
        Stocks stocks = Stocks.builder()
                .stockName(stockRequest.getStockName())
                .stockPrice(stockRequest.getStockPrice())
                .stockQuantity(stockRequest.getStockQuantity())
                .stockTime(Instant.now())
                .build();
        log.info("ADDING STOCK...");
        stockServiceRepository.save(stocks);

        return StockResponse.builder()
                .stockMessage("YOUR STOCK WAS ADDED!")
                .stockId(stocks.getStockId())
                .stockName(stocks.getStockName())
                .stockPrice(stocks.getStockPrice())
                .stockQuantity(stocks.getStockQuantity())
                .stockTime(stocks.getStockTime())
                .build();
    }
}
