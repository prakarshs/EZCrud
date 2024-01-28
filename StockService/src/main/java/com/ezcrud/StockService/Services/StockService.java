package com.ezcrud.StockService.Services;

import com.ezcrud.StockService.Models.StockRequest;
import com.ezcrud.StockService.Models.StockResponse;

public interface StockService {
    StockResponse add(StockRequest stockRequest);
}
