/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Time;

/**
 *
 * @author dat26
 */
public class ThuModel {
    String nameThu;
    String mucThu;
    Double amountThu;
    Time timeThu;

    public ThuModel() {
    }

    @Override
    public String toString() {
        return "NhanvienModel{" + "Ten khoan thu=" + nameThu + ", Danh muc=" + mucThu + ", So tien=" + amountThu + ","
                + " Ngay=" + timeThu + "}";
    }

    public ThuModel(String nameThu, String mucThu, Double amountThu, Time timeThu) {
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

    public Time getTimeThu() {
        return timeThu;
    }

    public void setTimeThu(Time timeThu) {
        this.timeThu = timeThu;
    }

    

   
    
    
}
