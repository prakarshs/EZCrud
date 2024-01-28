package com.ezcrud.StockService.Models;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockResponse {
    private String stockMessage;
    private Long stockId;
    private String stockName;
    private Long stockPrice;
    private Long stockQuantity;
    private Instant stockTime;
}
