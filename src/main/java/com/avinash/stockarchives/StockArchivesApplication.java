package com.avinash.stockarchives;

import com.avinash.stockarchives.bo.StockPrice;
import com.avinash.stockarchives.service.StockPriceService;
import com.avinash.stockarchives.service.StockService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StockArchivesApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(StockArchivesApplication.class, args);

		configurableApplicationContext.getBean(StockService.class).saveAll();

		configurableApplicationContext.getBean(StockPriceService.class).saveAll();
	}
}
