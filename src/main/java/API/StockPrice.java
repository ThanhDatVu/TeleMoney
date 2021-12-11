/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package API;

import java.io.IOException;
import java.math.BigDecimal;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

/**
 *
 * @author dat26
 */
public class StockPrice {

    public void take() throws IOException {
        Stock stock = YahooFinance.get("TSLA");

        BigDecimal price = stock.getQuote().getPrice();
        BigDecimal change = stock.getQuote().getChangeInPercent();
        BigDecimal peg = stock.getStats().getPeg();
        BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();

        stock.print();
        System.out.println(price);
    }

    public static void main(String[] args) throws IOException {
        StockPrice sp = new StockPrice();
        sp.take();
    }
}
