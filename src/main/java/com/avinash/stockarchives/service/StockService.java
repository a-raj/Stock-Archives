package com.avinash.stockarchives.service;

import com.avinash.stockarchives.bo.Stock;
import com.avinash.stockarchives.dao.StockRepository;
import com.avinash.stockarchives.utility.exports.StocksExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    private final StockRepository stockRepository;

    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }


    public List<Stock> getAll(){
        return stockRepository.findAll();
    }

    public void saveAll() {
        stockRepository.saveAll(StocksExport.doStocksExport());
    }

    public void save(Stock stock) {
        stockRepository.save(stock);
    }

}
