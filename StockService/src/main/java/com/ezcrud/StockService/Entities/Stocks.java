package com.ezcrud.StockService.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "STOCK_DETAILS")
public class Stocks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockId;
    @Column(name = "STOCK_NAME")
    private String stockName;
    @Column(name = "STOCK_PRICE")
    private Long stockPrice;
    @Column(name = "STOCK_QUANTITY")
    private Long stockQuantity;
    @Column(name = "STOCK_TIME")
    private Instant stockTime;
}
