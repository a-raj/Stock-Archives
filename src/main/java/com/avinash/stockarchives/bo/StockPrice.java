package com.avinash.stockarchives.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
@Table(name = "stock_price")
@JsonIgnoreProperties(value = {"id"})
public class StockPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "date")
    private Date date;

    @Transient
    @CsvBindByName(column = "date")
    private String dateString;

    @CsvBindByName
    private String symbol;

    @CsvBindByName
    private double open;

    @CsvBindByName
    private double close;

    @CsvBindByName
    private double low;

    @CsvBindByName
    private double high;

    @CsvBindByName
    private double volume;

    public StockPrice() {
    }

    public StockPrice(Date date,String dateString, String symbol, double open, double close, double low, double high, double volume) throws ParseException {

        this.dateString = dateString;
        formatDate(dateString);

        this.symbol = symbol;
        this.open = open;
        this.close = close;
        this.low = low;
        this.high = high;
        this.volume = volume;
    }

    private void formatDate(String dateString) throws ParseException {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatDateAndTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try{
            String[] dateAndTime = dateString.split(" ");

            if (dateAndTime.length > 1) {
                this.date = formatDateAndTime.parse(dateString);
            }
            else {
                this.date = formatDate.parse(dateString);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDateString(String dateString) throws Exception{
       formatDate(dateString);
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "StockPrice{" +
                "id=" + id +
                ", date=" + date +
                ", symbol='" + symbol + '\'' +
                ", open=" + open +
                ", close=" + close +
                ", low=" + low +
                ", high=" + high +
                ", volume=" + volume +
                '}';
    }
}
