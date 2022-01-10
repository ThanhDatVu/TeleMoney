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
public class GuiTienTransModel {

    int id;
    int guiTienID;
    private String ten;
    private String bank;
    private double sotien;
    private Timestamp time;
    

    public GuiTienTransModel() {

    }

    public GuiTienTransModel(int id, int traGopID, String ten, String bank, double sotien, Timestamp time) {
        this.id = id;
        this.guiTienID = traGopID;
        this.ten = ten;
        this.bank = bank;
        this.sotien = sotien;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGuiTienID() {
        return guiTienID;
    }

    public void setGuiTienID(int traGopID) {
        this.guiTienID = traGopID;
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

    public double getSotien() {
        return sotien;
    }

    public void setSotien(double sotien) {
        this.sotien = sotien;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
    

    

}
