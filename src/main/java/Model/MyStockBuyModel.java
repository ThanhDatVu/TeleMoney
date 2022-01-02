/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.IOException;
import static java.lang.ProcessBuilder.Redirect.to;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import static java.time.LocalDateTime.from;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.Interval;
import java.sql.Timestamp;
import java.time.Instant;

/**
 *
 * @author dat26
 */
public class MyStockBuyModel {

    private String symbol;
    private String name;
    private int soLuong;
    private float tongBanDau;
    private float giaBanDau;
    Timestamp time;

    public MyStockBuyModel(String symbol, String name, int soLuong, float giaBanDau, Timestamp time) {
        this.symbol = symbol;
        this.name = name;
        this.soLuong = soLuong;
        this.giaBanDau = giaBanDau;
        this.time = time;
        this.tongBanDau = soLuong * giaBanDau;

    }

    public MyStockBuyModel() {

    }

    public Float get24hchange() {
        Float rounded = null;
        try {
            Calendar from = Calendar.getInstance();
            Calendar to = Calendar.getInstance();
            from.add(Calendar.DAY_OF_WEEK, -5);
            Stock google = YahooFinance.get(symbol, from, to, Interval.DAILY);
            BigDecimal price = google.getQuote().getPrice();
//            System.out.println(google.getHistory().get(0));
//            System.out.println(google.getHistory().get(0).getAdjClose());
//            System.out.println(google.getHistory().get(1));
//            System.out.println(google.getHistory().get(1).getAdjClose());

            Float change24h = 10000 * ((google.getHistory().get(2).getAdjClose().floatValue() / google.getHistory().get(0).getAdjClose().floatValue()) - 1);
//            System.out.println(change24h);
            rounded = (float) Math.round(change24h);
//            System.out.println(rounded / 100 + "%");
        } catch (IOException ex) {
            Logger.getLogger(MyStockBuyModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rounded / 100;
    }

    public Timestamp getTime() {

        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setTongBanDau(float tongBanDau) {
        this.tongBanDau = tongBanDau;
    }

    public void setGiaBanDau(float giaBanDau) {
        this.giaBanDau = giaBanDau;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public float getTongBanDau() {
        return tongBanDau;
    }

    public float getGiaBanDau() {
        return giaBanDau;
    }

    public int getSoNgay() {
        int diff = 0;
        System.out.println(this.time.toInstant());
        Timestamp now = new Timestamp(System.currentTimeMillis());
        return diff;
    }

    @Override
    public String toString() {
        return "MyStockBuyModel{" + "symbol=" + symbol + ", name=" + name + ", soLuong=" + soLuong + ", tongBanDau=" + tongBanDau + ", giaBanDau=" + giaBanDau + ", time=" + time + '}';
    }
    
}
