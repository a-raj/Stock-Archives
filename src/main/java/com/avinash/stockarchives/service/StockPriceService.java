package com.avinash.stockarchives.service;

import com.avinash.stockarchives.bo.StockPrice;
import com.avinash.stockarchives.dao.StockPriceRepository;
import com.avinash.stockarchives.utility.csv.CSVImportData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockPriceService {

    private final StockPriceRepository stockPriceRepository;

    @Autowired
    public StockPriceService(StockPriceRepository stockPriceRepository) {
        this.stockPriceRepository = stockPriceRepository;
    }

    public List<StockPrice> getAll() {
        return stockPriceRepository.findAll();
    }

    public void saveAll() {
        stockPriceRepository.saveAll(CSVImportData.importData());
    }

}
