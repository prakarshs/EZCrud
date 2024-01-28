package com.ezcrud.StockService.Services;

import com.ezcrud.StockService.Entities.Stocks;
import com.ezcrud.StockService.Models.StockListResponse;
import com.ezcrud.StockService.Models.StockRequest;
import com.ezcrud.StockService.Models.StockResponse;

import java.util.List;

public interface StockService {
    StockResponse add(StockRequest stockRequest);

    StockResponse show(Long stockId);

    StockListResponse showAll();
}
