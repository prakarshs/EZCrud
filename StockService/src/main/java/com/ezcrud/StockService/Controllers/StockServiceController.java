package com.ezcrud.StockService.Controllers;

import com.ezcrud.StockService.Models.StockRequest;
import com.ezcrud.StockService.Models.StockResponse;
import com.ezcrud.StockService.Services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stocks")
public class StockServiceController {

    @Autowired
    public StockService stockService;

    @PostMapping("/add")
    private ResponseEntity<StockResponse> add(@RequestBody StockRequest stockRequest){
        return new ResponseEntity<>(stockService.add(stockRequest),HttpStatus.OK);
    }
}
