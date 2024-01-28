package com.ezcrud.StockService.Services;

import com.ezcrud.StockService.Models.StockListResponse;
import com.ezcrud.StockService.Models.StockRequest;
import com.ezcrud.StockService.Models.StockResponse;

public interface StockService {
    StockResponse add(StockRequest stockRequest);

    StockResponse show(Long stockId);

    StockListResponse showAll();

    StockListResponse remove(Long stockId);

    StockResponse changePrice(Long stockId, Long newPrice);
}
