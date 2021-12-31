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
public class VayTienModel {
    private String ten;
    private String bank;
    private double tiengoc;
    private double laisuat;
    private int kyhan;
    private Timestamp ngayvay;

    public VayTienModel(String ten, String bank, double tiengoc, double laisuat, int kyhan, Timestamp ngayvay) {
        this.ten = ten;
        this.bank = bank;
        this.tiengoc = tiengoc;
        this.laisuat = laisuat;
        this.kyhan = kyhan;
        this.ngayvay = ngayvay;
    }

    public VayTienModel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    

    public String getTen() {
        return ten;
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

    public double getTiengoc() {
        return tiengoc;
    }

    public void setTiengoc(double tiengoc) {
        this.tiengoc = tiengoc;
    }

    public double getLaisuat() {
        return laisuat;
    }

    public void setLaisuat(double laisuat) {
        this.laisuat = laisuat;
    }

    public int getKyhan() {
        return kyhan;
    }

    public void setKyhan(int kyhan) {
        this.kyhan = kyhan;
    }

    public Timestamp getNgayvay() {
        return ngayvay;
    }

    public void setNgayvay(Timestamp ngayvay) {
        this.ngayvay = ngayvay;
    }
    
    
}
