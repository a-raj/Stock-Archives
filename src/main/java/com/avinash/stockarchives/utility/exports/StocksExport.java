package com.avinash.stockarchives.utility.exports;

import com.avinash.stockarchives.bo.Stock;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StocksExport {
    private static final String STOCK_XLSX_FILE_PATH = "stocks.xlsx";


    public static List<Stock> doStocksExport(){

        try {
            Workbook workbook = WorkbookFactory.create(new File(STOCK_XLSX_FILE_PATH));
            Sheet sheet = workbook.getSheetAt(0);

            int lastRowNumber = sheet.getLastRowNum();
            List<Stock> stocks = new ArrayList<>(lastRowNumber);

            for (int i = 1; i < lastRowNumber; i++) {
                Row row = sheet.getRow(i);
                Cell cellSymbol = row.getCell(0);
                Cell cellName = row.getCell(1);
                Cell cellMarketCap = row.getCell(2);
                Cell cellSector = row.getCell(3);
                Cell cellIndustry = row.getCell(4);

                Stock stock = new Stock();
                stock.setSymbol(cellSymbol.getStringCellValue());
                stock.setName(cellName.getStringCellValue());
                stock.setMarketCap(cellMarketCap.getNumericCellValue());
                stock.setSector(cellSector.getStringCellValue());
                stock.setIndustry(cellIndustry.getStringCellValue());

                stocks.add(stock);
            }
            return stocks;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

}
