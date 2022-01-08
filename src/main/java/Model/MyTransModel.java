package Model;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import lib.ButtonColumn;

/**
 * @author dat2611@
 *
 */
@SuppressWarnings("serial")
public class MyTransModel {

    private String symbol;
    private int soLuong;
    private float giaGiaoDich;
    private String loaiGiaoDich;
    private Timestamp time;

    public MyTransModel() {
    }

    public MyTransModel(String symbol, int soLuong, float giaGiaoDich, String loaiGiaoDich, Timestamp time) {
        this.symbol = symbol;
        this.soLuong = soLuong;
        this.giaGiaoDich = giaGiaoDich;
        this.loaiGiaoDich = loaiGiaoDich;
        this.time = time;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getGiaGiaoDich() {
        return giaGiaoDich;
    }

    public void setGiaGiaoDich(float giaGiaoDich) {
        this.giaGiaoDich = giaGiaoDich;
    }

    public String getLoaiGiaoDich() {
        return loaiGiaoDich;
    }

    public void setLoaiGiaoDich(String loaiGiaoDich) {
        this.loaiGiaoDich = loaiGiaoDich;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

}
