/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Timestamp;

/**
 *
 * @author dat26
 */
public class ChiModel {
    int idChi;
    String nameChi;
    String mucChi;
    Double amountChi;
    Timestamp timeChi;

    public ChiModel() {
    }

    @Override
    public String toString() {
        return "NhanvienModel{" + "Ten khoan chi=" + nameChi + ", Danh muc=" + mucChi + ", So tien=" + amountChi + ","
                + " Ngay=" + timeChi + "}";
    }

    public ChiModel(String nameChi, String mucChi, Double amountChi, Timestamp timeChi) {
        this.nameChi = nameChi;
        this.mucChi = mucChi;
        this.amountChi = amountChi;
        this.timeChi = timeChi;
    }

    public int getIdChi() {
        return idChi;
    }

    public void setIdChi(int chiid) {
        this.idChi = chiid;
    }

    public Timestamp getTimeChi() {
        return timeChi;
    }

    public void setTimeChi(Timestamp timeChi) {
        this.timeChi = timeChi;
    }

    public String getNameChi() {
        return nameChi;
    }

    public void setNameChi(String nameChi) {
        this.nameChi = nameChi;
    }

    public String getMucChi() {
        return mucChi;
    }

    public void setMucChi(String mucChi) {
        this.mucChi = mucChi;
    }

    public Double getAmountChi() {
        return amountChi;
    }

    public void setAmountChi(Double amountChi) {
        this.amountChi = amountChi;
    }

    public Timestamp getTimestampChi() {
        return timeChi;
    }

    public void setTimestampChi(Timestamp timeChi) {
        this.timeChi = timeChi;
    }

    
}
