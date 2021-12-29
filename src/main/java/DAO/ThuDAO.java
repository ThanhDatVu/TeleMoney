/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.ThuModel;
import Model.ThuTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author dat26
 */
public class ThuDAO {

    private Connection con;

    public ThuDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/telemoney", "root", "");
//here sonoo is database name, root is username and password  

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void refresh(ThuTableModel nvmodel) {
        nvmodel.setRowCount(0);
        addall(nvmodel);
    }

    public void addall(ThuTableModel nvmodel) {
        String sql = "select * from NHANVIEN";

        ThuModel nv = null;
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nv = new ThuModel();
                nv.setNameThu(rs.getString("Tên khoản thu"));
                nv.setAmountThu(rs.getDouble("Số tiền"));
                nv.setDescriptionThu(rs.getString("Mô tả"));
                nv.setDateThu(rs.getDate("Ngày"));
                nvmodel.addRow(new Object[]{nv.getNameThu(), nv.getAmountThu(), nv.getDescriptionThu(), nv.getDateThu()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printall(ThuTableModel nvmodel) {
        String sql = "select * from NHANVIEN";

        ThuModel nv = null;
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nv = new ThuModel();
                nv.setNameThu(rs.getString("Tên khoản thu"));
                nv.setAmountThu(rs.getDouble("Số tiền"));
                nv.setDescriptionThu(rs.getString("Mô tả"));
                nv.setDateThu(rs.getDate("Ngày"));
                System.out.println(nv.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(ThuModel nv) {
        String sql = "INSERT INTO NHANVIEN (MANV, HOTEN, LUONG) VALUES (?,?,?)";;

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, nv.getNameThu());
            ps.setDouble(2, nv.getAmountThu());
            ps.setString(3, nv.getDescriptionThu());
            ps.setDate(4, nv.getDateThu());

            int executeUpdate = ps.executeUpdate();
            System.out.println(nv.toString());
            System.out.println("Thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(ThuModel nv, ThuModel nv2) {
        //To change body of generated methods, choose Tools | Templates.
        String sql = "UPDATE NHANVIEN SET MANV = ?, HOTEN = ?, LUONG = ? WHERE MANV = ?;";;

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, nv.getNameThu());
            ps.setDouble(2, nv.getAmountThu());
            ps.setString(3, nv.getDescriptionThu());
            ps.setDate(4, nv.getDateThu());

            int executeUpdate = ps.executeUpdate();
            System.out.println(nv2.toString());
            System.out.println("Sửa thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    

    public void delete(ThuModel nv) {
       String sql = "DELETE FROM NHANVIEN WHERE MANV = ? and HOTEN = ? and LUONG = ?";;

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
             ps.setString(1, nv.getNameThu());
            ps.setDouble(2, nv.getAmountThu());
            ps.setString(3, nv.getDescriptionThu());
            ps.setDate(4, nv.getDateThu());
            

            int executeUpdate = ps.executeUpdate();
            
            System.out.println("Xoá thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

}
