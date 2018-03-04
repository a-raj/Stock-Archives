package com.avinash.stockarchives.utility.csv;

import com.avinash.stockarchives.bo.StockPrice;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CSVImportData {

    private static final String STOCK_PRICE_CSV_FILE_PATH = "prices.csv";

    public static List<StockPrice> importData() {

        // TODO : do thing parallel for performance: creating list and pushing it to db
        try ( Reader reader = Files.newBufferedReader(Paths.get(STOCK_PRICE_CSV_FILE_PATH)); ){
            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType(StockPrice.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<StockPrice> stockPrices = csvToBean.parse();

            return stockPrices;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
