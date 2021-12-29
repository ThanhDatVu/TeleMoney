/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author dat26
 */
public class ThuModel {
    String nameThu;
    Double amountThu;
    String descriptionThu;
    Date dateThu;

    public ThuModel() {
    }

    @Override
    public String toString() {
        return "NhanvienModel{" + "Khoan thu=" + nameThu + ", So tien=" + amountThu + ", Mo ta=" + descriptionThu + ","
                + " Ngay=" + dateThu + "}";
    }

    public ThuModel(String nameThu, Double amountThu, String descriptionThu, Date dateThu) {
        this.nameThu = nameThu;
        this.amountThu = amountThu;
        this.descriptionThu = descriptionThu;
        this.dateThu = dateThu;
    }

    public String getNameThu() {
        return nameThu;
    }

    public void setNameThu(String nameThu) {
        this.nameThu = nameThu;
    }

    public Double getAmountThu() {
        return amountThu;
    }

    public void setAmountThu(Double amountThu) {
        this.amountThu = amountThu;
    }

    public String getDescriptionThu() {
        return descriptionThu;
    }

    public void setDescriptionThu(String descriptionThu) {
        this.descriptionThu = descriptionThu;
    }

    public Date getDateThu() {
        return dateThu;
    }

    public void setDateThu(Date dateThu) {
        this.dateThu = dateThu;
    }

   
    
    
}
