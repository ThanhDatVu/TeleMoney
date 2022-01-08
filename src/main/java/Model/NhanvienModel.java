/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author dat26
 */
public class NhanvienModel {

    String maNV;
    String hoTen;
    String luong;

    public NhanvienModel() {
    }

    @Override
    public String toString() {
        return "NhanvienModel{" + "maNV=" + maNV + ", hoTen=" + hoTen + ", luong=" + luong + '}';
    }

    public NhanvienModel(String maNV, String hoTen, String luong) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.luong = luong;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getLuong() {
        return luong;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setLuong(String luong) {
        this.luong = luong;
    }

}
