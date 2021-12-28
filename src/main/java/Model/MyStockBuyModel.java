/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    LocalDateTime time;
    

    public MyStockBuyModel(String symbol, String name, int soLuong, float giaBanDau, LocalDateTime time) {
        this.symbol = symbol;
        this.name = name;
        this.soLuong = soLuong;
        this.giaBanDau = giaBanDau;
        this.time = time;
        this.tongBanDau = soLuong * giaBanDau;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
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

}
