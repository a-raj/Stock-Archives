package com.avinash.stockarchives.bo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "stock")
@JsonIgnoreProperties(value = {"id"}, allowGetters = true, allowSetters = false)
public class Stock implements Serializable{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id")
    private long id;

    @NotBlank
    @Column(name = "symbol")
    private String symbol;

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "market_cap")
    private Double marketCap;

    @NotBlank
    @Column(name = "sector")
    private String sector;

    @NotBlank
    @Column(name = "industry")
    private String industry;


    public Stock(String symbol, String name, Double marketCap, String sector, String industry) {
        this.symbol = symbol;
        this.name = name;
        this.marketCap = marketCap;
        this.sector = sector;
        this.industry = industry;
    }

    public Stock() {}

    public long getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(Double marketCap) {
        this.marketCap = marketCap;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", marketCap=" + marketCap +
                ", sector='" + sector + '\'' +
                ", industry='" + industry + '\'' +
                '}';
    }
}
