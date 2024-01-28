package com.ezcrud.StockService.Services;

import com.ezcrud.StockService.Entities.Stocks;
import com.ezcrud.StockService.Errors.CustomError;
import com.ezcrud.StockService.Models.StockListResponse;
import com.ezcrud.StockService.Models.StockRequest;
import com.ezcrud.StockService.Models.StockResponse;
import com.ezcrud.StockService.Repositories.StockServiceRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;

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
        log.info("STOCK ADDED.");


        return StockResponse.builder()
                .stockMessage("YOUR STOCK WAS ADDED!")
                .stockId(stocks.getStockId())
                .stockName(stocks.getStockName())
                .stockPrice(stocks.getStockPrice())
                .stockQuantity(stocks.getStockQuantity())
                .stockTime(stocks.getStockTime())
                .build();
    }

    @Override
    public StockResponse show(Long stockId) {
        log.info("VALIDATING STOCKID...");
        Stocks stocks = stockServiceRepository.findById(stockId).orElseThrow(()->new CustomError("The StockId Doesnt Exist.","Try With A different Stockid"));

        return StockResponse.builder()
                .stockMessage("YOUR STOCK WAS FOUND!")
                .stockId(stocks.getStockId())
                .stockName(stocks.getStockName())
                .stockPrice(stocks.getStockPrice())
                .stockQuantity(stocks.getStockQuantity())
                .stockTime(stocks.getStockTime())
                .build();
    }

    @Override
    public StockListResponse showAll() {
        log.info("FETCHING INVENTORY...");
        return StockListResponse.builder()
                .messageStockList(":: LIST OF OUR INVENTORY ITEMS ::")
                .stockList(new ArrayList<>(stockServiceRepository.findAll()))
                .build();
    }

    @Override
    public StockListResponse remove(Long stockId) {
        log.info("VALIDATING STOCKID...");
        Stocks stocks = stockServiceRepository.findById(stockId).orElseThrow(()->new CustomError("The StockId Doesnt Exist.","Try With A different Stockid"));
        log.info("REMOVING STOCK...");
        stockServiceRepository.delete(stocks);
        return StockListResponse.builder()
                .messageStockList(":: LIST OF OUR UPDATED INVENTORY ITEMS ::")
                .stockList(new ArrayList<>(stockServiceRepository.findAll()))
                .build();
    }

    @Override
    public StockResponse changePrice(Long stockId, Long newPrice) {
        log.info("VALIDATING STOCKID...");
        Stocks stocks = stockServiceRepository.findById(stockId).orElseThrow(()->new CustomError("The StockId Doesnt Exist.","Try With A different Stockid"));

        log.info("UPDATING PRICE...");
        stocks.setStockPrice(newPrice);

        return StockResponse.builder()
                .stockMessage("PRICE WAS UPDATED!")
                .stockId(stocks.getStockId())
                .stockName(stocks.getStockName())
                .stockPrice(stocks.getStockPrice())
                .stockQuantity(stocks.getStockQuantity())
                .stockTime(stocks.getStockTime())
                .build();
    }
}
