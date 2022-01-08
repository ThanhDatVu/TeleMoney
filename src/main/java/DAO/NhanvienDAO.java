/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.NhanvienModel;
import Model.NhanvienTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author dat26
 */
public class NhanvienDAO {

    private Connection con;

    public NhanvienDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/telemoney", "root", "");
//here sonoo is database name, root is username and password  

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void refresh(NhanvienTableModel nvmodel) {
        nvmodel.setRowCount(0);
        addall(nvmodel);
    }

    public void addall(NhanvienTableModel nvmodel) {
        String sql = "select * from NHANVIEN";

        NhanvienModel nv = null;
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nv = new NhanvienModel();
                nv.setHoTen(rs.getString("HOTEN"));
                nv.setMaNV(rs.getString("MANV"));
                nv.setLuong(rs.getString("LUONG"));
                nvmodel.addRow(new Object[]{nv.getMaNV(), nv.getHoTen(), nv.getLuong(), "Xoá", "Sửa"});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printall(NhanvienTableModel nvmodel) {
        String sql = "select * from NHANVIEN";

        NhanvienModel nv = null;
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nv = new NhanvienModel();
                nv.setHoTen(rs.getString("HOTEN"));
                nv.setMaNV(rs.getString("MANV"));
                nv.setLuong(rs.getString("LUONG"));
                System.out.println(nv.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(NhanvienModel nv) {
        String sql = "INSERT INTO NHANVIEN (MANV, HOTEN, LUONG) VALUES (?,?,?)";;

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, nv.getMaNV());
            ps.setString(2, nv.getHoTen());
            ps.setString(3, nv.getLuong());

            int executeUpdate = ps.executeUpdate();
            System.out.println(nv.toString());
            System.out.println("thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(NhanvienModel nv, NhanvienModel nv2) {
        //To change body of generated methods, choose Tools | Templates.
        String sql = "UPDATE NHANVIEN SET MANV = ?, HOTEN = ?, LUONG = ? WHERE MANV = ?;";;

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, nv2.getMaNV());

            ps.setString(2, nv2.getHoTen());
            ps.setString(3, nv2.getLuong());
            ps.setString(4, nv.getMaNV());

            int executeUpdate = ps.executeUpdate();
            System.out.println(nv2.toString());
            System.out.println("Sửa");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void delete(NhanvienModel nv) {
        String sql = "DELETE FROM NHANVIEN WHERE MANV = ? and HOTEN = ? and LUONG = ?";;

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, nv.getMaNV());

            ps.setString(2, nv.getHoTen());
            ps.setString(3, nv.getLuong());

            int executeUpdate = ps.executeUpdate();

            System.out.println("Xoá");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
