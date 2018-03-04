package com.avinash.stockarchives.controller;

import com.avinash.stockarchives.bo.Stock;
import com.avinash.stockarchives.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public List<Stock> getAllCompanies() {
        return stockService.getAll();
    }


    @PostMapping
    public void save(@Valid @RequestBody Stock stock){
         stockService.save(stock);
    }
}
