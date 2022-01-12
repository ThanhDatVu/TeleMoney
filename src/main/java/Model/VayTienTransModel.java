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
public class VayTienTransModel {

    int id;
    int vayTienID;
    private String ten;
    private String bank;
    private String status;
    private double sotien;
    private Timestamp time;

    public VayTienTransModel() {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public VayTienTransModel(int id, int traGopID, String ten, String bank, double sotien, Timestamp time) {
        this.id = id;
        this.vayTienID = traGopID;
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

    public int getVayTienID() {
        return vayTienID;
    }

    public void setVayTienID(int traGopID) {
        this.vayTienID = traGopID;
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

    @Override
    public String toString() {
        return "VayTienTransModel{" + "id=" + id + ", vayTienID=" + vayTienID + ", ten=" + ten + ", bank=" + bank + ", sotien=" + sotien + ", time=" + time + '}';
    }
    public String toReadableString() {
        return " " + ten + ", tại ngân hàng " + bank + ", với số tiền " + sotien + "VND, vào ngày " + time.toLocalDateTime().toLocalDate().toString() + " ";
    }
}
