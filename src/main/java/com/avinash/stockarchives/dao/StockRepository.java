package com.avinash.stockarchives.dao;

import com.avinash.stockarchives.bo.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

}
