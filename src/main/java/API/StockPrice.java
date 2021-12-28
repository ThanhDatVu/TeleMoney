/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package API;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.Interval;

/**
 *
 * @author dat26
 */
public class StockPrice {

    public void take() throws IOException {
        // Stock stock = YahooFinance.get("USDVND=X");
        Stock stock = YahooFinance.get("AAPL");

        BigDecimal price = stock.getQuote().getPrice();
        BigDecimal change = stock.getQuote().getChangeInPercent();
        BigDecimal peg = stock.getStats().getPeg();
        BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();

        stock.print();
        System.out.println(price);
    }

    public Stock get(String s) throws IOException {
        return YahooFinance.get(s);
    }

    public static void main(String[] args) throws IOException {
        StockPrice sp = new StockPrice();
        sp.take();
        Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();
        from.add(Calendar.DAY_OF_WEEK, -1); // from 5 years ago

        Stock google = YahooFinance.get("GOOG", from, to, Interval.DAILY);
        BigDecimal price = google.getQuote().getPrice();
        System.out.println(google.getHistory().get(0));
        System.out.println(google.getHistory().get(0).getAdjClose());
        System.out.println(google.getHistory().get(1));
        System.out.println(google.getHistory().get(1).getAdjClose());
        
        Float change24h = 10000*(1-(google.getHistory().get(1).getAdjClose().floatValue()/google.getHistory().get(0).getAdjClose().floatValue()));
        System.out.println(change24h);
        Float rounded =(float) Math.round(change24h);
        System.out.println(rounded/100 + "%");
    }
}
