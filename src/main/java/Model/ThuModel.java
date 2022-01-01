/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author dat26
 */
public class ThuModel {
    String nameThu;
    String mucThu;
    Double amountThu;
    Date dateThu;

    public ThuModel() {
    }

    @Override
    public String toString() {
        return "ThuModel{" + "Ten khoan thu=" + nameThu + ", Danh muc=" + mucThu + ", So tien=" + amountThu + ","
                + " Ngay=" + dateThu + "}";
    }

    public ThuModel(String nameThu, String mucThu, Double amountThu, Date dateThu) {
        this.nameThu = nameThu;
        this.mucThu = mucThu;
        this.amountThu = amountThu;
        this.dateThu = dateThu;
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

    public Date getDateThu() {
        return dateThu;
    }

    public void setDateThu(Date dateThu) {
        this.dateThu = dateThu;
    }

   
    

   
    
    
}
