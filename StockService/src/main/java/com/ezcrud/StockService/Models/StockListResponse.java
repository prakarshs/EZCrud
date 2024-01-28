package com.ezcrud.StockService.Models;

import com.ezcrud.StockService.Entities.Stocks;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockListResponse {
    private String messageStockList;
    private List<Stocks> stockList;
}
