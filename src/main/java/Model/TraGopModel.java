/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Timestamp;

/**
 *
 * @author xiaomi
 */
public class TraGopModel {
    private String ten;
    private String bank;
    private double tongtien;
    private double tienhangthang;
    private int sothang;
    private Timestamp time;
    private double tratruoc;
    private int ngaytragop;
    
    public TraGopModel(){
        
    }

    public TraGopModel(String ten, String bank, double tongtien, double tienhangthang, int sothang, Timestamp time, double tratruoc, int ngaytragop) {
        this.ten = ten;
        this.bank = bank;
        this.tongtien = tongtien;
        this.tienhangthang = tienhangthang;
        this.sothang = sothang;
        this.time = time;
        this.tratruoc = tratruoc;
        this.ngaytragop = ngaytragop;
    }

    public String getTen() {
        return ten;
    }

    public int getNgaytragop() {
        return ngaytragop;
    }

    public void setNgaytragop(int ngaytragop) {
        this.ngaytragop = ngaytragop;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public double getTienhangthang() {
        return tienhangthang;
    }

    public void setTienhangthang(double tienhangthang) {
        this.tienhangthang = tienhangthang;
    }

    public int getSothang() {
        return sothang;
    }

    public void setSothang(int sothang) {
        this.sothang = sothang;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public double getTratruoc() {
        return tratruoc;
    }

    public void setTratruoc(double tratruoc) {
        this.tratruoc = tratruoc;
    }

  
}
