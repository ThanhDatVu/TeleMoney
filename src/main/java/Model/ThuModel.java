/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Timestamp;
import java.sql.Time;

/**
 *
 * @author dat26
 */
public class ThuModel {

    int idThu;

    String nameThu;
    String mucThu;
    Double amountThu;
    Timestamp timeThu;

    public ThuModel() {
    }

    @Override
    public String toString() {
        return "ThuModel{" + "Ten khoan thu=" + nameThu + ", Danh muc=" + mucThu + ", So tien=" + amountThu + ","
                + " Ngay=" + timeThu + "}";
    }

    public int getIdThu() {
        return idThu;
    }

    public void setIdThu(int idThu) {
        this.idThu = idThu;
    }

    public Timestamp getTimeThu() {
        return timeThu;
    }

    public void setTimeThu(Timestamp timeThu) {
        this.timeThu = timeThu;
    }

    public ThuModel(String nameThu, String mucThu, Double amountThu, Timestamp timeThu) {
        this.nameThu = nameThu;
        this.mucThu = mucThu;
        this.amountThu = amountThu;
        this.timeThu = timeThu;
    }

    public String getNameThu() {
        return nameThu;
    }

    public void setNameThu(String nameThu) {
        this.nameThu = nameThu;
    }

    public String getMucThu() {
        return mucThu;
    }

    public void setMucThu(String mucThu) {
        this.mucThu = mucThu;
    }

    public Double getAmountThu() {
        return amountThu;
    }

    public void setAmountThu(Double amountThu) {
        this.amountThu = amountThu;
    }

    public Timestamp getTimestampThu() {
        return timeThu;
    }

    public void setTimestampThu(Timestamp timeThu) {
        this.timeThu = timeThu;
    }

}
