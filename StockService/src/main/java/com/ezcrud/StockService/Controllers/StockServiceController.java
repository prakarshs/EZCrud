package com.ezcrud.StockService.Controllers;

import com.ezcrud.StockService.Entities.Stocks;
import com.ezcrud.StockService.Models.StockListResponse;
import com.ezcrud.StockService.Models.StockRequest;
import com.ezcrud.StockService.Models.StockResponse;
import com.ezcrud.StockService.Services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockServiceController {

    @Autowired
    public StockService stockService;

    @PostMapping("/add")
    private ResponseEntity<StockResponse> add(@RequestBody StockRequest stockRequest){
        return new ResponseEntity<>(stockService.add(stockRequest),HttpStatus.OK);
    }
    @GetMapping("/show/{id}")
    private ResponseEntity<StockResponse> show(@PathVariable("id") Long stockId){
        return new ResponseEntity<>(stockService.show(stockId),HttpStatus.OK);
    }
    @GetMapping("/showAll")
    private ResponseEntity<StockListResponse> showAll(){
        return new ResponseEntity<>(stockService.showAll(),HttpStatus.OK);
    }

}
